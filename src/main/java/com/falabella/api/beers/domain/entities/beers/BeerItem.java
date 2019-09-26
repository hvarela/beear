package com.falabella.api.beers.domain.entities.beers;

import com.falabella.api.beers.domain.entities.error.BeerItemException;
import com.falabella.api.beers.domain.entities.error.ErrorType;
import org.springframework.util.StringUtils;

public class BeerItem{

    int id;
    String  name;
    String brewery;
    String country;
    float price;
    String currency;

    public BeerItem(int id, String name, String brewery, String country, float price, String currency) {
        this.id = id;
        this.name = name;
        this.brewery = brewery;
        this.country = country;
        this.price = price;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public void validate(){
        if( StringUtils.isEmpty(this.name) || StringUtils.isEmpty(this.brewery) || StringUtils.isEmpty(this.country) ||
                StringUtils.isEmpty(this.currency)  ){
            throw  new BeerItemException(ErrorType.BEER_INVALID_PARAMETE, ErrorType.BEER_INVALID_PARAMETE.getDescription());
        }
    }
}
