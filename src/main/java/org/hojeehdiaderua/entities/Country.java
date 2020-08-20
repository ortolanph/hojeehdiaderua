package org.hojeehdiaderua.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "country")
@SequenceGenerator(name = "seq_country", sequenceName = "seq_county", allocationSize = 1)
@Getter
@Setter
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_location")
    private Long id;
    @Column(length = 2)
    private String code;
    private String name;
    private String timezone;

}
