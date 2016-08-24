package org.hojeehdiaderua.beans.calendario;

import java.util.List;

public class Calendario {
    private int dia;
    private String diaSemana;
    private String mes;
    private int ano;
    private List<Localidade> localidades;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<Localidade> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidade> localidades) {
        this.localidades = localidades;
    }
}
