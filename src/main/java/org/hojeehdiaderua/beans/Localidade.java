package org.hojeehdiaderua.beans;

public class Localidade {
    private String cidade;
    private String uf;

    public Localidade() {

    }

    public Localidade(String cidade, String uf) {
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
