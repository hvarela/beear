package com.falabella.api.beers.infrastructure.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity( name="Beers")
@Getter
@Setter
public class BeersEntity {
    @Id
    @Basic(optional = false)
    private Integer id;
    @Column
    private String name;
    @Column
    private String brewery;
    @Column
    private String country;
    @Column
    private String currency;
    @Column
    private Float price;

    public  BeersEntity(){};

    public BeersEntity(Integer id, String name, String brewery, String country, String currency, Float price) {
        this.id = id;
        this.name = name;
        this.brewery = brewery;
        this.country = country;
        this.currency = currency;
        this.price = price;
    }
}