package org.hojeehdiaderua.old;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HojeEhDiaDeRua {

    @Autowired
    private static Environment environment;

    public static void main(String[] args) {
        GeoApiContext context = new GeoApiContext().setApiKey(environment.getProperty("API_KEY"));

        try {
            GeocodingResult[] results = GeocodingApi.geocode(context,
                    "Avenida 14 de Dezembro, Brasil").await();

            System.out.println("Quatro de Maio, Brasil");
            System.out.println("-[Resultados]-");
            for (GeocodingResult result : results) {
                System.out.println("===================================================");

                boolean ehRua = false;

                for (AddressComponent addressComponent : result.addressComponents) {
                    if (ehRota(addressComponent.types)) {
                        System.out.println(addressComponent.longName);
                        ehRua = true;
                    }

                    if (ehCidade(addressComponent.types) && ehRua) {
                        System.out.println(addressComponent.longName);
                    }

                    if (ehEstado(addressComponent.types) && ehRua) {
                        System.out.println(addressComponent.longName);
                        System.out.println(addressComponent.shortName);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean ehRota(AddressComponentType[] types) {
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
