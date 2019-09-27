package com.falabella.api.beers.infrastructure.repository;

import com.falabella.api.beers.domain.entities.beers.BeerItem;
import com.falabella.api.beers.domain.entities.error.BeerNotFoundException;
import com.falabella.api.beers.domain.entities.error.DuplicateBeerItemException;
import com.falabella.api.beers.domain.usecases.ports.BeerDataProvider;
import com.falabella.api.beers.infrastructure.entities.BeersEntity;
import com.falabella.api.beers.infrastructure.repository.translate.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class BeerRepository implements BeerDataProvider {

    private BeerCrud beerCrud;
    private ModelConverter modelConverter;

    @Autowired
    BeerRepository(BeerCrud beerCrud, ModelConverter modelConverter){
        this.beerCrud = beerCrud;
        this.modelConverter = modelConverter;
    }

    @Override
    public BeerItem addBeer(BeerItem beer) {

        Optional<BeersEntity> beersEntityFound = beerCrud.findById( beer.getId());

        if( beersEntityFound.isPresent() ) throw new DuplicateBeerItemException();

        BeersEntity beersEntity =  beerCrud.save(  modelConverter.convert(beer));

        return beer;
    }

    @Override
    public Collection<BeerItem> getAllBeers() {

        BeerItem beerItem;
        List<BeerItem> result = new ArrayList<BeerItem>();
        Iterable<BeersEntity> beersEntities =  beerCrud.findAll();

        for( BeersEntity beerEntity : beersEntities ){
            beerItem = modelConverter.convert(beerEntity);
            result.add(  beerItem);
        }

        return result;
    }

    @Override
    public BeerItem getBeer(int id) {
        Optional<BeersEntity> beersEntityFound = beerCrud.findById(id);

        if( !beersEntityFound.isPresent() ) throw new BeerNotFoundException();

        return  modelConverter.convert(  beersEntityFound.get());

    }
}
