package com.falabella.api.beers.infrastructure.repository.translate;

import com.falabella.api.beers.domain.entities.beers.BeerItem;
import com.falabella.api.beers.infrastructure.entities.BeersEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component

public class ModelConverter {

    public ModelConverter(){
    }

    public BeerItem convert(BeersEntity beersEntity){

        BeerItem beerItem = new BeerItem(beersEntity.getId(), beersEntity.getName(),beersEntity.getBrewery(),
                beersEntity.getCountry(), beersEntity.getCurrency(),  beersEntity.getPrice());

        return beerItem;
    }

    public BeersEntity convert(BeerItem beerItem){
        BeersEntity beersEntity = new BeersEntity(beerItem.getId(), beerItem.getName(), beerItem.getBrewery(),
                beerItem.getCountry(),beerItem.getCurrency(), beerItem.getPrice());
        return beersEntity;
    }


}
