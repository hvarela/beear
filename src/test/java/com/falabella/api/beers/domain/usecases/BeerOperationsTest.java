package com.falabella.api.beers.domain.usecases;

import com.falabella.api.beers.domain.entities.beers.BeerBox;
import com.falabella.api.beers.domain.entities.beers.BeerItem;
import com.falabella.api.beers.domain.entities.error.BeerNotFoundException;
import com.falabella.api.beers.domain.entities.error.DuplicateBeerItemException;
import com.falabella.api.beers.domain.usecases.ports.BeerDataProvider;
import com.falabella.api.beers.domain.usecases.ports.CurrecyDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BeerOperationsTest {

    @Mock
    private BeerDataProvider beerDataProvider;

    @Mock
    private CurrecyDataProvider currecyDataProvider;

    private BeerOperations beerOperations;

    private BeerItem beerItem;
    private List<BeerItem> beerItems;

    @Before
    public void  configTest(){
        beerItems = new ArrayList<BeerItem>();
        beerOperations = new BeerOperations(beerDataProvider, currecyDataProvider);
        beerItem = new BeerItem(2,"escudo","ccu","CL","CLP", new Float(200.0) );

        beerItems.add( beerItem);
        beerItems.add(new BeerItem(3,"cristal","ccu","CL","CLP", new Float(250.0)));
        beerItems.add(new BeerItem(4,"sol","modelo","MX","MX", new Float(250.0)));

    }

    @Test
    public void testgetBeerByid(){
        Optional<BeerItem> ret = Optional.of(beerItem);
        Mockito.when(beerDataProvider.getBeer(anyInt())).thenReturn(ret);

        BeerItem beerbyId = beerOperations.getBeerbyId(2);

        assertThat( beerbyId.getId()).isEqualTo( 2);
        assertThat( beerbyId.getBrewery()).isEqualTo( "ccu");
        assertThat( beerbyId.getCountry()).isEqualTo( "CL");
        assertThat( beerbyId.getCurrency()).isEqualTo( "CLP");
        assertThat( beerbyId.getName()).isEqualTo( "escudo");
        assertThat( beerbyId.getPrice()).isEqualTo( new Float(200.0));

    }

    @Test( expected = BeerNotFoundException.class)
    public void testgetBeerbyIdandNotFoundId(){
        Optional<BeerItem> ret = Optional.empty();
        Mockito.when(beerDataProvider.getBeer(anyInt())).thenReturn(ret);

        BeerItem beerbyId = beerOperations.getBeerbyId(2);

    }

    @Test()
    public void testinsertBeer(){
        BeerItem dummy = new BeerItem(4,"casa","da","d","d",new Float(2));
        Optional<BeerItem> ret = Optional.empty();

        Mockito.when(beerDataProvider.getBeer(anyInt())).thenReturn(ret);
        Mockito.when(beerDataProvider.addBeer(any(BeerItem.class))).thenReturn(beerItem);

        BeerItem insert = beerOperations.addBeer(dummy);

        assertThat( insert.getId()).isEqualTo( 2);
        assertThat( insert.getBrewery()).isEqualTo( "ccu");
        assertThat( insert.getCountry()).isEqualTo( "CL");
        assertThat( insert.getCurrency()).isEqualTo( "CLP");
        assertThat( insert.getName()).isEqualTo( "escudo");
        assertThat( insert.getPrice()).isEqualTo( new Float(200.0));


    }

    @Test( expected = DuplicateBeerItemException.class)
    public void testInsertDuplicateBeerIdandThrowException(){
        BeerItem dummy = new BeerItem(4,"casa","da","d","d",new Float(2));
        Optional<BeerItem> ret = Optional.of(dummy);

        Mockito.when(beerDataProvider.getBeer(anyInt())).thenReturn(ret);


        BeerItem insert = beerOperations.addBeer(dummy);

    }

    @Test()
    public void testGetAllBeer(){
        BeerItem dummy = new BeerItem(4,"casa","da","d","d",new Float(2));
        Optional<BeerItem> ret = Optional.of(dummy);

        Mockito.when(beerDataProvider.getAllBeers()).thenReturn(beerItems);

        Collection<BeerItem> all = beerOperations.getAllBeer();

        assertThat( all.size()).isEqualTo(3);

    }

    @Test()
    public void testGetBeerBoxPrice(){
        Optional<BeerItem> ret = Optional.of(beerItem);

        Mockito.when(beerDataProvider.getBeer(anyInt())).thenReturn(ret);
        Mockito.when(currecyDataProvider.getCurrencyConverionRate(any(),any())).thenReturn( new Float(2));

        BeerBox beerBox = beerOperations.getBeerBoxPrice(2, 2, "CLP");


        assertThat( beerBox.getTotalPrice() ).isEqualTo(  (float)800.0);

    }

    @Test( expected = BeerNotFoundException.class)
    public void testGetBeerBoxPriceAndNotFoundBeerId(){
        Optional<BeerItem> ret = Optional.empty();

        Mockito.when(beerDataProvider.getBeer(anyInt())).thenReturn(ret);

        BeerBox beerBox = beerOperations.getBeerBoxPrice(2, 2, "CLP");


    }
}
