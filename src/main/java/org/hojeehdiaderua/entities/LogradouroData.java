package org.hojeehdiaderua.entities;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "logradourodata", schema = "diaderua")
@SequenceGenerator(name = "seq_loda", schema = "diaderua", sequenceName = "diaderua.seq_logdata", allocationSize = 1)
public class LogradouroData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_loda")
    @Column(name = "loda_id")
    private long id;

    @Column(name = "loda_dia")
    private Byte dia;

    @Column(name = "loda_mes")
    private Byte mes;

    @Column(name = "loda_cidade")
    private String cidade;

    @Column(name = "loda_uf")
    private String uf;

    @Column(name = "loda_latitude")
    private double latitude;

    @Column(name = "loda_longitude")
    private double longitude;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Byte getDia() {
        return dia;
    }

    public void setDia(Byte dia) {
        this.dia = dia;
    }

    public Byte getMes() {
        return mes;
    }

    public void setMes(Byte mes) {
        this.mes = mes;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogradouroData that = (LogradouroData) o;
        return id == that.id &&
                Objects.equals(dia, that.dia) &&
                Objects.equals(mes, that.mes) &&
                Objects.equals(cidade, that.cidade) &&
                Objects.equals(uf, that.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dia, mes, cidade, uf);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("dia", dia)
                .add("mes", mes)
                .add("cidade", cidade)
                .add("uf", uf)
                .add("latitude", latitude)
                .add("longitude", longitude)
                .toString();
    }
}
