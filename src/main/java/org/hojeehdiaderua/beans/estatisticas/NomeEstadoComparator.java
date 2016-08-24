package org.hojeehdiaderua.beans.estatisticas;

import com.google.common.collect.Maps;

import java.util.Comparator;
import java.util.Map;

public class NomeEstadoComparator implements Comparator<String> {

    private final Map<String, Integer> estados = Maps.newHashMap();

    public NomeEstadoComparator() {
        estados.put("Janeiro", 1);
        estados.put("Fevereiro", 2);
        estados.put("Março", 3);
        estados.put("Abril", 4);
        estados.put("Maio", 5);
        estados.put("Junho", 6);
        estados.put("Julho", 7);
        estados.put("Agosto", 8);
        estados.put("Setembro", 9);
        estados.put("Outubro", 10);
        estados.put("Novembro", 11);
        estados.put("Dezembro", 12);
    }

    @Override
    public int compare(String estado1, String estado2) {
        return estados.get(estado1) - estados.get(estado2);
    }
}
