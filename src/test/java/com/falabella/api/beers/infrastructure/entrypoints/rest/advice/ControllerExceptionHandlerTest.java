package com.falabella.api.beers.infrastructure.entrypoints.rest.advice;

import com.falabella.api.beers.domain.entities.error.ApiError;
import com.falabella.api.beers.domain.entities.error.BeerItemException;
import com.falabella.api.beers.domain.entities.error.InternalErrorException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ControllerExceptionHandlerTest {

    @InjectMocks
    ControllerExceptionHandler controllerExceptionHandler;

    @Test
    public void testHandleRequestValidations() {
        ApiError apiError = controllerExceptionHandler.handleBeerItemException(
                new BeerItemException()
        );
        assertFalse("message is not empty", apiError.getMessage().isEmpty());
        assertTrue("the message is Request invalida ", "Request invalida".equalsIgnoreCase(apiError.getMessage()));

    }



    @Test
    public void testHandleRunTime() {
        ApiError apiError = controllerExceptionHandler.handleRunTime(new InternalErrorException());
        assertFalse("message is not empty", apiError.getMessage().isEmpty());
        assertTrue("the message is Unexpected error", "Unexpected error".equalsIgnoreCase(apiError.getMessage()));
        assertTrue(  apiError.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}