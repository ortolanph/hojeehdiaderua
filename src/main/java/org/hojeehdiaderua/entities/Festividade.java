package org.hojeehdiaderua.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "festividade", schema = "diaderua")
@SequenceGenerator(name = "seq_festa", schema = "diaderua", sequenceName = "diaderua.seq_festividade", allocationSize = 1)
public class Festividade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_festa")
    @Column(name="fest_id")
    private Long id;

    @Column(name="fest_dia")
    private Byte dia;

    @Column(name="fest_mes")
    private Byte mes;

    @Column(name="fest_festividade")
    private String festividade;

    @Column(name="fest_fonte")
    private String fonte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getFestividade() {
        return festividade;
    }

    public void setFestividade(String festividade) {
        this.festividade = festividade;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Festividade that = (Festividade) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dia, that.dia) &&
                Objects.equals(mes, that.mes) &&
                Objects.equals(festividade, that.festividade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dia, mes, festividade);
    }
}
