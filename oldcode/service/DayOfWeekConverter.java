package org.hojeehdiaderua.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.function.Function;

@Service
public class DayOfWeekConverter implements Function<DayOfWeek, String> {

    private static String[] DIAS_DA_SEMANA = new String[]{
            "Segunda-Feira",
            "Terça-Feira",
            "Quarta-Feira",
            "Quinta-Feira",
            "Sexta-Feira",
            "Sábado",
            "Domingo"
    };

    @Override
    public String apply(DayOfWeek dayOfWeek) {
        return DIAS_DA_SEMANA[dayOfWeek.getValue() - 1];
    }
}
