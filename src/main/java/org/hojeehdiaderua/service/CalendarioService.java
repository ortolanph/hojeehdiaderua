package org.hojeehdiaderua.service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;
import org.hojeehdiaderua.beans.Grafia;
import org.hojeehdiaderua.entities.LogradouroData;
import org.hojeehdiaderua.repositories.FestividadeRepository;
import org.hojeehdiaderua.repositories.LogradouroDataRepository;
import org.hojeehdiaderua.utils.ExecucaoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.*;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

@Service
public class CalendarioService {

    @Autowired
    private LogradouroDataRepository logradouroDataRepository;

    @Autowired
    private FestividadeRepository festividadeRepository;

    @Autowired
    private GeoApiContext geoApiContext;

    @Autowired
    private Environment environment;

    @Autowired
    private MonthConverter monthConverter;

    private List<LogradouroData> todosLogradourosDestaData;

    private ExecucaoManager execucaoManager;

    public void obterNomesDeRuas(int dia, int mes, ExecucaoManager execucaoManager) {
        try {
            execucaoManager.adicionaLog("Obtendo todas as possibilidades de ruas");
            List<String> possibilidades = construirPossibilidades(dia, mes);

            execucaoManager.adicionaLog(possibilidades.toString());

            execucaoManager.adicionaLog("Pesquisando no Google");
            Set<LogradouroData> logradouros = newHashSet();

            for(String possibilidade : possibilidades) {
                GeocodingResult[] results = GeocodingApi.geocode(geoApiContext,
                        String.format("%s, Brasil", possibilidade)).await();

                for (GeocodingResult result : results) {
                    boolean ehRua = false;
                    LogradouroData logradouroData = null;

                    for (AddressComponent addressComponent : result.addressComponents) {
                        if (ehRota(addressComponent.types)) {
                            execucaoManager.adicionaLog(String.format("Encontrou o logradouro %s...", addressComponent.longName));
                            logradouroData = new LogradouroData();
                            logradouroData.setDia((byte) dia);
                            logradouroData.setMes((byte) mes);

                            if(dia < 10 && addressComponent.longName.contains("Vinte")) {
                                ehRua = false;
                            } else {
                                ehRua = true;
                            }
                        }

                        if (ehCidade(addressComponent.types) && ehRua) {
                            execucaoManager.adicionaLog(String.format("... na cidade %s ...", addressComponent.longName));
                            logradouroData.setCidade(addressComponent.longName);

                        }

                        if (ehEstado(addressComponent.types) && ehRua) {
                            execucaoManager.adicionaLog(String.format("... no estado %s - %s.", addressComponent.longName, addressComponent.shortName));
                            logradouroData.setUf(addressComponent.shortName);
                            logradouros.add(logradouroData);
                        }
                    }
                }
            }

            loadAll(dia, mes);

            logradouros
                    .stream()
                    .filter(l -> !todosLogradourosDestaData.contains(l))
                    .forEach(l -> logradouroDataRepository.saveAndFlush(l));

            execucaoManager.adicionaLog(logradouros.toString());
        } catch (Exception e) {
            execucaoManager.adicionaLog(e.getMessage());
        }
    }

    private void loadAll(int dia, int mes) {
        todosLogradourosDestaData = logradouroDataRepository.findByDiaMes((byte)dia, (byte)mes);
        todosLogradourosDestaData.forEach(l -> l.setId(0));
    }

    private boolean ehRota(AddressComponentType[] types) {
        return contemTipo(AddressComponentType.ROUTE, types);
    }

    public static boolean ehCidade(AddressComponentType[] types) {
        return contemTipo(AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_2, types)
                && contemTipo(AddressComponentType.POLITICAL, types);
    }

    public static boolean ehEstado(AddressComponentType[] types) {
        return contemTipo(AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_1, types)
                && contemTipo(AddressComponentType.POLITICAL, types);
    }

    private static boolean contemTipo(AddressComponentType tipo, AddressComponentType[] tipos) {
        List<AddressComponentType> types = new ArrayList<>(Arrays.asList(tipos));

        return types.contains(tipo);
    }

    private List<String> construirPossibilidades(int dia, int mes) {
        List<String> possibilidades = newArrayList();

        String mesEscrito = String.format(" de %s", monthConverter.apply(Month.of(mes)));
        Grafia grafia = Grafia.getGrafiaPorDia(dia);

        List<String> grafias = Arrays.asList(grafia.getPossiveisGrafias());
        List<String> tipos = Arrays.asList(environment.getProperty("tipos.logradouros").split(","));

        tipos.forEach(
                t -> grafias.forEach(
                        g -> possibilidades.add(
                                String.format("%s %s %s", t, g, mesEscrito).trim()
                        )
                )
        );

        return possibilidades;
    }
}
