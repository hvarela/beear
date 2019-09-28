package com.falabella.api.beers.domain.entities.error;

import java.util.Objects;
import java.util.StringJoiner;

public class ApiError {

    private int status;
    private String message;


    public ApiError(int httpStatus, String message) {
        this.status = httpStatus;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
