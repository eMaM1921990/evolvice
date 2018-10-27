package com.evolvice.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "CARS")
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "ID")
    private Long id;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "YEAR_OF_PRODUCTION")
    private Integer yearOfProduction;

    @Column(name = "CAR_TYPE")
    private String type;

}
