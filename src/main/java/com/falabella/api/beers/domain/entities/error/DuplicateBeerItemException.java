package com.falabella.api.beers.domain.entities.error;


public class DuplicateBeerItemException extends InternalErrorException {

    public DuplicateBeerItemException(){
        super( ErrorType.BEERID_DUPLICATE, ErrorType.BEERID_DUPLICATE.getDescription());
    }
}
