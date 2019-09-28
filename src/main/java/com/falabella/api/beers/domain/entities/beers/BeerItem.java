package com.falabella.api.beers.domain.entities.beers;

import com.falabella.api.beers.domain.entities.error.BeerItemException;
import com.falabella.api.beers.domain.entities.error.ErrorType;
import org.springframework.util.StringUtils;

public class BeerItem{
    private Integer id;
    private String name;
    private String brewery;
    private String country;
    private String currency;
    private Float price;

    public  BeerItem(){};

    public BeerItem(Integer id, String name, String brewery, String country, String currency, Float price) {
        this.id = id;
        this.name = name;
        this.brewery = brewery;
        this.country = country;
        this.price = price;
        this.currency = currency;
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

    public void validate(){

        if( this.id == null  || this.price == null || StringUtils.isEmpty(this.name) || StringUtils.isEmpty(this.brewery) || StringUtils.isEmpty(this.country) ||
                StringUtils.isEmpty(this.currency)  ){
            throw  new BeerItemException();
        }
    }
}
