package com.falabella.api.beers.domain.usecases.ports;


import com.falabella.api.beers.domain.entities.beers.BeerItem;
import java.util.Collection;


public interface BeerDataProvider {
    void addBeer(BeerItem beer);
    Collection<BeerItem> getAllBeers();
}
