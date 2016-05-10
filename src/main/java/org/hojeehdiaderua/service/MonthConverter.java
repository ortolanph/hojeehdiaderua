package org.hojeehdiaderua.service;

import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.function.Function;

@Service
public class MonthConverter implements Function<Month, String> {

    private static String[] MESES = new String[] {
            "JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"
    };

    @Override
    public String apply(Month month) {
        return MESES[month.getValue() - 1];
    }
}
