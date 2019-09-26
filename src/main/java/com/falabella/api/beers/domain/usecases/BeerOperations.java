package com.falabella.api.beers.domain.usecases;

import com.falabella.api.beers.domain.entities.beers.BeerItem;
import com.falabella.api.beers.domain.usecases.ports.BeerDataProvider;

import java.util.Collection;


public class BeerOperations{

    private BeerDataProvider beerDataProvider;

    public BeerOperations(BeerDataProvider beerDataProvider){
        this.beerDataProvider = beerDataProvider;
    }

    public void addBeer(BeerItem beerItem){
        beerDataProvider.addBeer(beerItem);
    }

    public Collection<BeerItem> getAllBeer(){
        return beerDataProvider.getAllBeers();
    }

}
