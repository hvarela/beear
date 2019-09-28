package com.falabella.api.beers.domain.entities.error;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class ErrorTypeTest {

    @Parameterized.Parameter()
    public ErrorType type;

    @Parameterized.Parameter(1)
    public String code;

    @Parameterized.Parameter(2)
    public String description;

    @Parameterized.Parameters(name = "{0}, {1}, {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {ErrorType.UNEXPECTED_ERROR, "TKT0001", "Unexpected error"}
        });
    }

    @Test
    public void testVerifyCorrectErrorCodes() {
        assertThat(type.getCode()).isEqualTo(code);
    }

    @Test
    public void testVerifyCorrectErrorDescriptions() {
        assertThat(type.getDescription()).isEqualTo(description);
    }

    @Test
    public  void testVerifyCorrectEnum(){
        ErrorType errorType = ErrorType.CURRENCY_SERVER_ERROR;

        assertThat(errorType.getCode()).isEqualTo( ErrorType.CURRENCY_SERVER_ERROR.getCode());


    }
}
