package com.falabella.api.beers.infrastructure.entrypoints.rest;

import com.falabella.api.beers.domain.entities.beers.BeerBox;
import com.falabella.api.beers.domain.entities.beers.BeerItem;
import com.falabella.api.beers.domain.entities.error.BeerItemException;
import com.falabella.api.beers.domain.usecases.BeerOperations;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class BeerControllerTest {

    @Mock
    BeerOperations beerOperations;

    @InjectMocks
    BeerController beerController;

    private List<BeerItem> beerItems;
    private BeerItem beerItem;


    @Before
    public void  configTest(){
        beerItems = new ArrayList<BeerItem>();
        beerItem = new BeerItem(2,"escudo","ccu","CL","CLP", new Float(200.0) );

        beerItems.add( beerItem);
        beerItems.add(new BeerItem(3,"cristal","ccu","CL","CLP", new Float(250.0)));
        beerItems.add(new BeerItem(4,"sol","modelo","MX","MX", new Float(250.0)));

    }


    @Test
    public void testGetBeertById() {

        BeerItem beerItem = new BeerItem(2,"cert","ccu","cl","CLP",new Float(200));
        Mockito.when(beerOperations.getBeerbyId(anyInt())).thenReturn(beerItem);
        BeerItem beerItem2 = beerController.searchBeers(2);
        assertTrue(beerItem2.getId() == beerItem.getId());
    }


    @Test
    public void testGetBeer() {
        Mockito.when(beerOperations.getAllBeer()).thenReturn(beerItems);
        Collection<BeerItem> beerItems = beerController.searchBeers();
        assertThat( beerItems.size() ).isEqualTo(3);
    }

    @Test
    public void testaddBeer() {
        Mockito.when(beerOperations.addBeer(any())).thenReturn(beerItem);
        BeerItem beerItem = beerController.addBeers(this.beerItem);
        assertThat( beerItem.getId() ).isEqualTo(2);
    }

    @Test( expected = BeerItemException.class)
    public void testaddInvalidBeerItemThrowException() {
        BeerItem beerItem = new BeerItem();
        
        BeerItem rtn = beerController.addBeers(beerItem);

    }

    @Test
    public void testgetBoxBeerPrice() {
        BeerBox beerBox = new BeerBox();
        beerBox.setTotalPrice( (float)33.3);

        Mockito.when(beerOperations.getBeerBoxPrice( anyInt(),anyInt(),any())).thenReturn(beerBox);

        BeerBox beerBox1 = beerController.searchBoxBeerPrice(1, 2, "CLP");
        assertThat( beerBox1.getTotalPrice() ).isEqualTo( (float)33.3);
    }


}