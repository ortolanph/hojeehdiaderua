package org.hojeehdiaderua.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.function.Function;

@Service
public class DayOfWeekConverter implements Function<DayOfWeek, String> {

    private static String[] DIAS_DA_SEMANA = new String[]{
            "SEG", "TER", "QUA", "QUI", "SEX", "SAB", "DOM"
    };

    @Override
    public String apply(DayOfWeek dayOfWeek) {
        return DIAS_DA_SEMANA[dayOfWeek.getValue() - 1];
    }
}
