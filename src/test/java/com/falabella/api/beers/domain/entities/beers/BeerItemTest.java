package com.falabella.api.beers.domain.entities.beers;

import com.falabella.api.beers.domain.entities.error.BeerItemException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class BeerItemTest {

    private BeerItem beerItem;

    @Test
    public void testCreateValidBeerItem() {

        beerItem = new BeerItem(2,"escudo","ccu","CL","SCL", new Float(200.0) );
        beerItem.validate();
        assertNotNull(beerItem);
    }

    @Test( expected = BeerItemException.class)
    public void  testthrowBeerItemException(){
        beerItem = new BeerItem();
        beerItem.validate();
    }

    @Test( expected = BeerItemException.class)
    public void  testValidateBeerItemPrice(){
        beerItem = new BeerItem();
        beerItem.setId(2);
        beerItem.setName("escudo");
        beerItem.setBrewery("ccu");
        beerItem.setCountry("CL");
        beerItem.setCurrency("CLP");
        beerItem.setPrice( null);
        beerItem.validate();
    }

    @Test( expected = BeerItemException.class)
    public void  testValidateBeerItemId(){
        beerItem = new BeerItem();
        beerItem.setId(null);
        beerItem.setName("escudo");
        beerItem.setBrewery("ccu");
        beerItem.setCountry("CL");
        beerItem.setCurrency("CLP");
        beerItem.setPrice( new Float(2));
        beerItem.validate();
    }

    @Test( expected = BeerItemException.class)
    public void  testValidateBeerItemName(){
        beerItem = new BeerItem();
        beerItem.setId(2);
        beerItem.setName("");
        beerItem.setBrewery("ccu");
        beerItem.setCountry("CL");
        beerItem.setCurrency("CLP");
        beerItem.setPrice( new Float(2));
        beerItem.validate();
    }

    @Test( expected = BeerItemException.class)
    public void  testValidateBeerItemBrewery(){
        beerItem = new BeerItem();
        beerItem.setId(null);
        beerItem.setName("escudo");
        beerItem.setBrewery("");
        beerItem.setCountry("CL");
        beerItem.setCurrency("CLP");
        beerItem.setPrice( new Float(2));
        beerItem.validate();
    }

    @Test( expected = BeerItemException.class)
    public void  testValidateBeerItemCountry(){
        beerItem = new BeerItem();
        beerItem.setId(null);
        beerItem.setName("escudo");
        beerItem.setBrewery("ccu");
        beerItem.setCountry("");
        beerItem.setCurrency("CLP");
        beerItem.setPrice( new Float(2));
        beerItem.validate();
    }

    @Test( expected = BeerItemException.class)
    public void  testValidateBeerItemCurrency(){
        beerItem = new BeerItem();
        beerItem.setId(null);
        beerItem.setName("escudo");
        beerItem.setBrewery("ccu");
        beerItem.setCountry("CL");
        beerItem.setCurrency("");
        beerItem.setPrice( new Float(2));
        beerItem.validate();
    }


}