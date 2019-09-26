package com.falabella.api.beers.infrastructure.entrypoints.rest.repository;

import com.falabella.api.beers.domain.entities.beers.BeerItem;
import com.falabella.api.beers.domain.usecases.ports.BeerDataProvider;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class BeerRepository implements BeerDataProvider {
    @Override
    public void addBeer(BeerItem beer) {

    }

    @Override
    public Collection<BeerItem> getAllBeers() {
        return null;
    }
}
