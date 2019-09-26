package com.falabella.api.beers.infrastructure.entrypoints.rest.advice;

import com.falabella.api.beers.domain.entities.error.ApiError;
import com.falabella.api.beers.domain.entities.error.ErrorType;
import com.falabella.api.beers.domain.entities.error.InternalErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler{

    Logger logger = LoggerFactory.getLogger( this.getClass());

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleRunTime(RuntimeException e) {
        loggerError(e);
        return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "handleRunTime", ErrorType.UNEXPECTED_ERROR.getDescription());
    }

    private void loggerError(InternalErrorException e){
        logger.error( String.format(" Error code [%d]   msg [%s] ",  e.getErrorType().getCode(), e.getMessage()));
    }

    private void loggerError(RuntimeException e){
        logger.error( String.format("Unexpected Error.  msg [%s] ",  e.getMessage()));
    }
}
