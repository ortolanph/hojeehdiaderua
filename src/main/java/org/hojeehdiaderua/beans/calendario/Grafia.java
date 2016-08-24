package org.hojeehdiaderua.beans.calendario;

import java.util.Arrays;

public enum Grafia {

    UM(1, new String[]{"1", "Um", "Primeiro"}),
    DOIS(2, new String[]{"2", "Dois"}),
    TRES(3, new String[]{"3", "Três"}),
    QUATRO(4, new String[]{"4", "Quatro"}),
    CINCO(5, new String[]{"5", "Cinco"}),
    SEIS(6, new String[]{"6", "Seis"}),
    SETE(7, new String[]{"7", "Sete"}),
    OITO(8, new String[]{"8", "Oito"}),
    NOVE(9, new String[]{"9", "Nove"}),
    DEZ(10, new String[]{"10", "Dez"}),
    ONZE(11, new String[]{"11", "Onze"}),
    DOZE(12, new String[]{"12", "Doze"}),
    TREZE(13, new String[]{"13", "Treze"}),
    CATORZE(14, new String[]{"14", "Catorze", "Quatorze"}),
    QUINZE(15, new String[]{"15", "Quinze", "XV"}),
    DEZESSEIS(16, new String[]{"16", "Dezesseis"}),
    DEZESSETE(17, new String[]{"17", "Dezessete"}),
    DEZOITO(18, new String[]{"18", "Dezoito"}),
    DEZENOVE(19, new String[]{"19", "Dezenove"}),
    VINTE(20, new String[]{"20", "Vinte"}),
    VINTE_E_UM(21, new String[]{"21", "Vinte e um"}),
    VINTE_E_DOIS(22, new String[]{"22", "Vinte e dois"}),
    VINTE_E_TRES(23, new String[]{"23", "Vinte e três"}),
    VINTE_E_QUATRO(24, new String[]{"24", "Vinte e quatro"}),
    VINTE_E_CINCO(25, new String[]{"25", "Vinte e cinco"}),
    VINTE_E_SEIS(26, new String[]{"26", "Vinte e seis"}),
    VINTE_E_SETE(27, new String[]{"27", "Vinte e sete"}),
    VINTE_E_OITO(28, new String[]{"28", "Vinte e oito"}),
    VINTE_E_NOVE(29, new String[]{"29", "Vinte e nove"}),
    TRINTA(30, new String[]{"30", "Trinta"}),
    TRINTA_E_UM(31, new String[]{"31", "Trinta e um"});

    private int dia;
    private String[] possiveisGrafias;

    Grafia(int dia, String[] possiveisGrafias) {
        this.dia = dia;
        this.possiveisGrafias = possiveisGrafias;
    }

    public static Grafia getGrafiaPorDia(int dia) {
        return Arrays.stream(values())
                .filter(d -> d.getDia() == dia)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                String.format("Dia %d inexistente. Todos os meses têm 28 dias, isso é um fato!", dia)
                        ));
    }

    public String[] getPossiveisGrafias() {
        return possiveisGrafias;
    }

    public int getDia() {
        return dia;
    }
}
