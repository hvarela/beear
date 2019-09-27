package com.falabella.api.beers.domain.entities.error;


public class ApiCurrencyException extends InternalErrorException {

    public ApiCurrencyException(){
        super( ErrorType.CURRENCY_SERVER_ERROR, ErrorType.CURRENCY_SERVER_ERROR.getDescription());
    }
}
