package com.falabella.api.beers.domain.usecases;

import com.falabella.api.beers.domain.entities.beers.BeerBox;
import com.falabella.api.beers.domain.entities.beers.BeerItem;
import com.falabella.api.beers.domain.entities.error.BeerNotFoundException;
import com.falabella.api.beers.domain.entities.error.DuplicateBeerItemException;
import com.falabella.api.beers.domain.usecases.ports.BeerDataProvider;
import com.falabella.api.beers.domain.usecases.ports.CurrecyDataProvider;
import com.falabella.api.beers.infrastructure.entities.BeersEntity;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;


public class BeerOperations{

    private BeerDataProvider beerDataProvider;
    private CurrecyDataProvider currecyDataProvider;

    public BeerOperations(BeerDataProvider beerDataProvider, CurrecyDataProvider currecyDataProvider){
        this.beerDataProvider = beerDataProvider;
        this.currecyDataProvider = currecyDataProvider;
    }

    public BeerItem addBeer(BeerItem beerItem){

        Optional<BeerItem> beer = beerDataProvider.getBeer(beerItem.getId());

        if( beer.isPresent()) throw new DuplicateBeerItemException();

        return beerDataProvider.addBeer(beerItem);
    }

    public Collection<BeerItem> getAllBeer(){
        return beerDataProvider.getAllBeers();
    }

    public  BeerItem getBeerbyId(int id){

        Optional<BeerItem> beer = beerDataProvider.getBeer(id);

        return getBeerItemIfExists(beer);
    }

    public BeerBox getBeerBoxPrice(int id, int quantity, String currency){
        BeerBox  beerBox = new BeerBox();
        BeerItem beerItem = getBeerItemIfExists(beerDataProvider.getBeer(id));
        Float rate = currecyDataProvider.getCurrencyConverionRate(beerItem.getCurrency(), currency);

        beerBox.setTotalPrice(quantity*rate*beerItem.getPrice());

        return beerBox;
    }

    private BeerItem  getBeerItemIfExists(Optional<BeerItem> beerItem){

        if( !beerItem.isPresent())  throw  new BeerNotFoundException();

        return beerItem.get();
    }


}
