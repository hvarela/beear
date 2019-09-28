package com.falabella.api.beers.infrastructure.repository.translate;

import com.falabella.api.beers.domain.entities.beers.BeerItem;
import com.falabella.api.beers.infrastructure.entities.BeersEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ModelConverterTest {

    @InjectMocks
    ModelConverter modelConverter;

    @Test
    public void convertBeerEntitieToBeerItem(){
        BeersEntity beersEntity = new BeersEntity(2,"corona","CCU","CL","CLP", new Float(2));

        BeerItem beerItem = modelConverter.convert(beersEntity);

        assertThat( beerItem.getId() ).isEqualTo(2);
        assertThat( beerItem.getName() ).isEqualTo("corona");
        assertThat( beerItem.getBrewery() ).isEqualTo("CCU");
        assertThat( beerItem.getCountry() ).isEqualTo("CL");
        assertThat( beerItem.getCurrency() ).isEqualTo("CLP");
        assertThat( beerItem.getPrice() ).isEqualTo( new Float(2));

    }

    @Test
    public void convertBeerItemToBeerEntitie(){
        BeerItem beerItem  = new BeerItem(2,"corona","CCU","CL","CLP", new Float(2));

        BeersEntity beersEntity = modelConverter.convert(beerItem);

        assertThat( beersEntity.getId() ).isEqualTo(2);
        assertThat( beersEntity.getName() ).isEqualTo("corona");
        assertThat( beersEntity.getBrewery() ).isEqualTo("CCU");
        assertThat( beersEntity.getCountry() ).isEqualTo("CL");
        assertThat( beersEntity.getCurrency() ).isEqualTo("CLP");
        assertThat( beersEntity.getPrice() ).isEqualTo( new Float(2));

    }
}
