package org.hojeehdiaderua.service;

import com.google.common.base.Strings;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;
import org.hojeehdiaderua.beans.calendario.Grafia;
import org.hojeehdiaderua.entities.LogradouroData;
import org.hojeehdiaderua.repositories.LogradouroDataRepository;
import org.hojeehdiaderua.utils.ExecucaoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

@Service
public class CalendarioService {

    public static final int PRIMEIRO_DIA = 1;
    public static final int DEZ = 10;
    private static final String VINTE_EXTENSO = "Vinte";
    private static final String TRINTA_EXTENSO = "Trinta";
    @Autowired
    private LogradouroDataRepository logradouroDataRepository;
    @Autowired
    private GeoApiContext geoApiContext;
    @Autowired
    private Environment environment;
    @Autowired
    private MonthConverter monthConverter;
    private List<LogradouroData> todosLogradourosDestaData;
    private ExecucaoManager execucaoManager;

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

    public void obterNomesDeRuas(int dia, int mes, ExecucaoManager execucaoManager) {
        String mesCorrente = monthConverter.apply(Month.of(mes));

        try {
            execucaoManager.adicionaLog("Obtendo todas as possibilidades de ruas");
            List<String> possibilidades = construirPossibilidades(dia, mes);

            execucaoManager.adicionaLog(possibilidades.toString());

            execucaoManager.adicionaLog("Pesquisando no Google");
            Set<LogradouroData> logradouros = newHashSet();

            for (String possibilidade : possibilidades) {
                GeocodingResult[] results = GeocodingApi.geocode(geoApiContext,
                        String.format("%s, Brasil", possibilidade)).await();

                for (GeocodingResult result : results) {
                    boolean ehRua = false;
                    LogradouroData logradouroData = null;

                    for (AddressComponent addressComponent : result.addressComponents) {
                        if (ehRota(addressComponent.types)) {
                            execucaoManager.adicionaLog(addressComponent.longName);

                            // verifica se o mes esta contido no string da rua
                            if (!addressComponent.longName.contains(mesCorrente)) {
                                ehRua = false;
                                break;
                            }

                            // verifica se o dia esta contido no string da rua
                            if (!verificaSePossuiPeloMenosUmaDasGrafias(addressComponent.longName, dia)) {
                                ehRua = false;
                                break;
                            }

                            // Se dia for menor do que 10, verificar se não existe a expressão vinte
                            if (dia < DEZ && addressComponent.longName.contains(VINTE_EXTENSO)) {
                                ehRua = false;
                                break;
                            } else {
                                ehRua = true;
                            }

                            // Se dia é 1, não pode vir com Trinta
                            if (dia == PRIMEIRO_DIA && addressComponent.longName.contains(TRINTA_EXTENSO)) {
                                ehRua = false;
                                break;
                            } else {
                                ehRua = true;
                            }

                            logradouroData = new LogradouroData();
                            logradouroData.setDia((byte) dia);
                            logradouroData.setMes((byte) mes);
                            logradouroData.setLatitude(result.geometry.location.lat);
                            logradouroData.setLongitude(result.geometry.location.lng);
                        }

                        if (ehCidade(addressComponent.types) && ehRua) {
                            execucaoManager.adicionaLog(addressComponent.longName);
                            logradouroData.setCidade(addressComponent.longName);

                        }

                        if (ehEstado(addressComponent.types) && ehRua) {
                            execucaoManager.adicionaLog(addressComponent.longName);
                            execucaoManager.adicionaLog(addressComponent.shortName);
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
                    .filter(l -> verificarIntegridade(l))
                    .forEach(l -> logradouroDataRepository.saveAndFlush(l));

            execucaoManager.adicionaLog(logradouros.toString());
        } catch (Exception e) {
            execucaoManager.adicionaLog(e.getMessage());
        }
    }

    private boolean verificaSePossuiPeloMenosUmaDasGrafias(String logradouro, int dia) {
        Grafia grafia = Grafia.getGrafiaPorDia(dia);

        return Arrays.stream(grafia.getPossiveisGrafias()).anyMatch(g -> logradouro.contains(" " + g + " "));
    }

    private boolean verificarIntegridade(LogradouroData l) {
        boolean cidadePreenchida = !Strings.isNullOrEmpty(l.getCidade());
        boolean estadoPreenchido = !Strings.isNullOrEmpty(l.getUf());

        return cidadePreenchida && estadoPreenchido;
    }

    private void loadAll(int dia, int mes) {
        todosLogradourosDestaData = logradouroDataRepository.findByDiaMes((byte) dia, (byte) mes);
        todosLogradourosDestaData.forEach(l -> l.setId(0));
    }

    private boolean ehRota(AddressComponentType[] types) {
        return contemTipo(AddressComponentType.ROUTE, types);
    }

    private List<String> construirPossibilidades(int dia, int mes) {
        List<String> possibilidades = newArrayList();

        String mesEscrito = String.format("de %s", monthConverter.apply(Month.of(mes)));
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

        grafias.forEach(g -> possibilidades.add(
                String.format("%s %s ", g, mesEscrito).trim()
        ));

        return possibilidades;
    }

    public List<Integer> obterDiasProcessados(int mes) {
        return
                logradouroDataRepository
                        .listAllProcessedDaysInMonth((byte) mes)
                        .stream()
                        .mapToInt(Byte::intValue)
                        .boxed()
                        .sorted((d1, d2) -> d1 - d2)
                        .collect(Collectors.toList());
    }
}
