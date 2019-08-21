package org.hojeehdiaderua.entities;

import javax.persistence.*;

@Entity
@Table(name = "logradouro", schema = "diaderua")
@SequenceGenerator(name = "seq_logr", schema = "diaderua", sequenceName = "diaderua.seq_logradouro", allocationSize = 1)
public class Logradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_logr")
    @Column(name = "logr_id")
    private Long id;

    @Column(name = "logr_cidade")
    private String cidade;

    @Column(name = "logr_uf")
    private String uf;

    @Column(name = "logr_latitude")
    private double latitude;

    @Column(name = "logr_longitude")
    private double longitude;

    @ManyToOne
    @JoinColumn(name = "logr_dm_id")
    private DiaMes diames;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public DiaMes getDiames() {
        return diames;
    }

    public void setDiames(DiaMes diames) {
        this.diames = diames;
    }
}
