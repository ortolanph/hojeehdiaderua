package org.hojeehdiaderua.service;

import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.function.Function;

@Service
public class MonthConverter implements Function<Month, String> {

    private static final String[] MESES = new String[]{
            "Janeiro", "Fevereiro", "Março",
            "Abril", "Maio", "Junho",
            "Julho", "Agosto", "Setembro",
            "Outubro", "Novembro", "Dezembro"
    };

    @Override
    public String apply(Month month) {
        return MESES[month.getValue() - 1];
    }
}
