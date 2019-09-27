package com.falabella.api.beers.domain.entities.error;


public class BeerNotFoundException extends InternalErrorException {

    public BeerNotFoundException(){
        super( ErrorType.BEERID_NOT_FOUND, ErrorType.BEERID_NOT_FOUND.getDescription());
    }
}
