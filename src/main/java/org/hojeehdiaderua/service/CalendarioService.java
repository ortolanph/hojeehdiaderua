package org.hojeehdiaderua.service;

import com.google.common.collect.Sets;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;
import org.hojeehdiaderua.entities.LogradouroData;
import org.hojeehdiaderua.repositories.FestividadeRepository;
import org.hojeehdiaderua.repositories.LogradouroDataRepository;
import org.hojeehdiaderua.utils.ExecucaoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class CalendarioService {

    @Autowired
    private LogradouroDataRepository logradouroDataRepository;

    @Autowired
    private FestividadeRepository festividadeRepository;

    @Autowired
    private GeoApiContext geoApiContext;

    private ExecucaoManager execucaoManager;

    public void obterNomesDeRuas(int dia, int mes, ExecucaoManager execucaoManager) {
        try {
            execucaoManager.adicionaLog("Obtendo todas as possibilidades de ruas");
            execucaoManager.adicionaLog("Pesquisando no Google");
            Set<LogradouroData> logradouros = Sets.newHashSet();

            GeocodingResult[] results = GeocodingApi.geocode(geoApiContext,
                    ", Brasil").await();

            for (GeocodingResult result : results) {
                boolean ehRua = false;
                LogradouroData logradouroData = null;

                for (AddressComponent addressComponent : result.addressComponents) {
                    if (ehRota(addressComponent.types)) {
                        execucaoManager.adicionaLog("Encontrou rua...");
                        logradouroData = new LogradouroData();
                        logradouroData.setDia((byte)dia);
                        logradouroData.setMes((byte)mes);
                        ehRua = true;
                    }

                    if (ehCidade(addressComponent.types) && ehRua) {
                        execucaoManager.adicionaLog(String.format("... na cidade %s ...", addressComponent.longName));
                        logradouroData.setCidade(addressComponent.longName);

                    }

                    if (ehEstado(addressComponent.types) && ehRua) {
                        execucaoManager.adicionaLog(String.format("... no estado %s/%s.", addressComponent.longName));
                        System.out.println(addressComponent.longName);
                        System.out.println(addressComponent.shortName);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
