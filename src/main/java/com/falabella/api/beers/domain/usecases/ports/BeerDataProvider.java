package com.falabella.api.beers.domain.usecases.ports;


import com.falabella.api.beers.domain.entities.beers.BeerItem;
import java.util.Collection;
import java.util.Optional;


public interface BeerDataProvider {
    BeerItem addBeer(BeerItem beer);
    Collection<BeerItem> getAllBeers();
    Optional<BeerItem> getBeer(int id);
}
