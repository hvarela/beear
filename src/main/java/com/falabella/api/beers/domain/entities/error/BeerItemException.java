package com.falabella.api.beers.domain.entities.error;


public class BeerItemException extends InternalErrorException {

    public BeerItemException(){
        super( ErrorType.BEER_INVALID_PARAMETE, ErrorType.BEER_INVALID_PARAMETE.getDescription());
    }
}
