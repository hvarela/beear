package com.falabella.api.beers.domain.usecases;

import com.falabella.api.beers.domain.entities.beers.BeerItem;
import com.falabella.api.beers.domain.usecases.ports.BeerDataProvider;
import com.falabella.api.beers.infrastructure.entities.BeersEntity;

import java.util.Collection;


public class BeerOperations{

    private BeerDataProvider beerDataProvider;

    public BeerOperations(BeerDataProvider beerDataProvider){
        this.beerDataProvider = beerDataProvider;
    }

    public BeerItem addBeer(BeerItem beerItem){
        return beerDataProvider.addBeer(beerItem);
    }

    public Collection<BeerItem> getAllBeer(){
        return beerDataProvider.getAllBeers();
    }

    public  BeerItem getBeerbyId(int id){
        return  beerDataProvider.getBeer(id);
    }



}
