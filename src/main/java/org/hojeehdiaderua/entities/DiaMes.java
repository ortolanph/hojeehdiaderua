package org.hojeehdiaderua.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "diames", schema = "diaderua")
@SequenceGenerator(name = "seq_dm", schema = "diaderua", sequenceName = "diaderua.seq_diames", allocationSize = 1)
public class DiaMes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dm")
    @Column(name = "dm_id")
    private Long id;

    @Column(name = "dm_dia")
    private int dia;

    @Column(name = "dm_mes")
    private int mes;

    @OneToMany(mappedBy = "diames")
    private List<Logradouro> logradouros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public List<Logradouro> getLogradouros() {
        return logradouros;
    }

    public void setLogradouros(List<Logradouro> logradouros) {
        this.logradouros = logradouros;
    }
}
