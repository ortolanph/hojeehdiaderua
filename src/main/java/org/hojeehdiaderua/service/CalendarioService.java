package org.hojeehdiaderua.service;

import com.google.maps.GeoApiContext;
import com.google.maps.model.AddressComponentType;
import org.hojeehdiaderua.repositories.LogradouroDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CalendarioService {

    @Autowired
    private GeoApiContext geoApiContext;

    @Autowired
    private LogradouroDataRepository repository;


    private boolean ehRota(AddressComponentType[] types) {
        return contemTipo(AddressComponentType.ROUTE, types);
    }

    private boolean ehCidade(AddressComponentType[] types) {
        return contemTipo(AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_2, types)
                && contemTipo(AddressComponentType.POLITICAL, types);
    }

    private boolean ehEstado(AddressComponentType[] types) {
        return contemTipo(AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_1, types)
                && contemTipo(AddressComponentType.POLITICAL, types);
    }

    private boolean contemTipo(AddressComponentType tipo, AddressComponentType[] tipos) {
        List<AddressComponentType> types = new ArrayList<>(Arrays.asList(tipos));

        return types.contains(tipo);
    }
}
