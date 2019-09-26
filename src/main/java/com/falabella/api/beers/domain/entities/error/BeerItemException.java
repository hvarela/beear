package com.falabella.api.beers.domain.entities.error;


public class BeerItemException extends InternalErrorException {

    public BeerItemException(String message) {
        super(message);
    }

    public BeerItemException(ErrorType errorType, String message) {
        super(errorType, message);
    }

    public BeerItemException(ErrorType errorType, String message, Exception exception) {
        super(errorType, message, exception);
    }
}
