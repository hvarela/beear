package com.falabella.api.beers.infrastructure.repository;

import com.falabella.api.beers.domain.entities.beers.BeerItem;
import com.falabella.api.beers.infrastructure.entities.BeersEntity;
import com.falabella.api.beers.infrastructure.repository.translate.ModelConverter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class BeerRepositoryTest {

    @Mock
    BeerCrud beerCrud;

    @Mock
    ModelConverter modelConverter;

    @InjectMocks
    BeerRepository beerRepository;

    private List<BeerItem> beerItems;
    private BeerItem beerItem;
    private BeersEntity beersEntity;


    @Before
    public void  configTest(){
        beerItems = new ArrayList<BeerItem>();
        beerItem = new BeerItem(2,"escudo","ccu","CL","CLP", new Float(200.0) );
        beersEntity = new BeersEntity(1,"escudo","ccu","CL","CLP", new Float(200.0) );

        beerItems.add( beerItem);
        beerItems.add(new BeerItem(3,"cristal","ccu","CL","CLP", new Float(250.0)));
        beerItems.add(new BeerItem(4,"sol","modelo","MX","MX", new Float(250.0)));

    }
    @Test
    public void testAddBeer(){


        Mockito.when(beerCrud.save(any())).thenReturn(beersEntity);
        Mockito.when(modelConverter.convert(any(BeersEntity.class))).thenReturn(beerItem);

        BeerItem rtn = beerRepository.addBeer(beerItem);
        assertThat( rtn.getId() ).isEqualTo(2);

    }


    @Test
    public void testFindBeerByIdandNotFound(){
        Optional<BeersEntity> dummy = Optional.empty();

        Mockito.when(beerCrud.findById(anyInt())).thenReturn(dummy);

        Optional<BeerItem> rtn = beerRepository.getBeer(2);

        assertFalse( rtn.isPresent() );

    }

    @Test
    public void testFindBeerById(){
        Optional<BeersEntity> base = Optional.of(beersEntity);

        Mockito.when(beerCrud.findById(anyInt())).thenReturn(base);
        Mockito.when(modelConverter.convert(any(BeersEntity.class))).thenReturn(beerItem);

        Optional<BeerItem> rtn = beerRepository.getBeer(2);

        assertTrue( rtn.isPresent() );

    }

    @Test
    public void testFindAllbeer(){
        List<BeersEntity> emptylist = new ArrayList<BeersEntity>();

        emptylist.add( beersEntity);


        Mockito.when(beerCrud.findAll()).thenReturn(emptylist);
        Mockito.when(modelConverter.convert(any(BeersEntity.class))).thenReturn(beerItem);

        Collection<BeerItem> allBeers = beerRepository.getAllBeers();

        assertThat( allBeers.size() ).isEqualTo(1);

    }



}
