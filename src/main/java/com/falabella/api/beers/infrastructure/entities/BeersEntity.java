package com.falabella.api.beers.infrastructure.entities;

import javax.persistence.*;

@Entity( name="Beers")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}