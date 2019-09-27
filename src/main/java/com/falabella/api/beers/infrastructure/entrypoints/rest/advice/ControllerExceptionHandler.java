package com.falabella.api.beers.infrastructure.entrypoints.rest.advice;

import com.falabella.api.beers.domain.entities.error.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler{

    Logger logger = LoggerFactory.getLogger( this.getClass());


    @ExceptionHandler(BeerItemException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleBeerItemException(BeerItemException e) {
        loggerError(e);
        return new ApiError(HttpStatus.BAD_REQUEST.value(), e.getErrorType().getDescription());
    }


    @ExceptionHandler(DuplicateBeerItemException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleDuplicateBeer(DuplicateBeerItemException e) {
        loggerError(e);
        return new ApiError(HttpStatus.CONFLICT.value(), e.getErrorType().getDescription());
    }

    @ExceptionHandler(BeerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleDuplicateBeer(BeerNotFoundException e) {
        loggerError(e);
        return new ApiError(HttpStatus.NOT_FOUND.value(), e.getErrorType().getDescription());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleRunTime(RuntimeException e) {
        loggerError(e);
        return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ErrorType.UNEXPECTED_ERROR.getDescription());
    }

    private void loggerError(InternalErrorException e){
        logger.error( String.format(" Error code [%s]   msg [%s] ",  e.getErrorType().getCode(), e.getMessage()));
    }

    private void loggerError(RuntimeException e){
        logger.error( String.format("Unexpected Error.  msg [%s] ",  e.getMessage()));
    }
}
