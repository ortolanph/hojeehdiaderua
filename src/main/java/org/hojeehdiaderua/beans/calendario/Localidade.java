package org.hojeehdiaderua.beans.calendario;

public class Localidade {
    private String cidade;
    private String uf;
    private double latitude;
    private double longitude;

    public Localidade() {

    }

    public Localidade(String cidade, String uf, double latitude, double longitude) {
        this.cidade = cidade;
        this.uf = uf;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
