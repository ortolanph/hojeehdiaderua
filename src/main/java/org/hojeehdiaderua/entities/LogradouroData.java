package org.hojeehdiaderua.entities;

import com.google.common.base.MoreObjects;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class LogradouroData {
    @Id
    private long id;
    private Byte dia;
    private Byte mes;
    private String cidade;
    private String uf;

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
                .toString();
    }
}
