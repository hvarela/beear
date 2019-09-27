package com.falabella.api.beers.domain.usecases;

import com.falabella.api.beers.domain.entities.beers.BeerBox;
import com.falabella.api.beers.domain.entities.beers.BeerItem;
import com.falabella.api.beers.domain.usecases.ports.BeerDataProvider;
import com.falabella.api.beers.domain.usecases.ports.CurrecyDataProvider;
import com.falabella.api.beers.infrastructure.entities.BeersEntity;

import java.util.Collection;


public class BeerOperations{

    private BeerDataProvider beerDataProvider;
    private CurrecyDataProvider currecyDataProvider;

    public BeerOperations(BeerDataProvider beerDataProvider, CurrecyDataProvider currecyDataProvider){
        this.beerDataProvider = beerDataProvider;
        this.currecyDataProvider = currecyDataProvider;
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

    public BeerBox getBeerBoxPrice(int id, int quantity, String currency){
        BeerBox  beerBox = new BeerBox();
        BeerItem  beerItem = beerDataProvider.getBeer(id);
        Float rate = currecyDataProvider.getCurrencyConverionRate(beerItem.getCountry(), currency);

        beerBox.setTotalPrice(quantity*rate*beerItem.getPrice());

        return beerBox;
    }



}
