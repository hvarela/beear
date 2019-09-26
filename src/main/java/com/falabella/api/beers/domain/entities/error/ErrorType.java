package com.falabella.api.beers.domain.entities.error;

public enum ErrorType {

    UNEXPECTED_ERROR("TKT0001", "Unexpected error"),
    BEER_INVALID_PARAMETE("TKT0002", "Invalid Parameter ");

    private final String code;
    private final String description;

    ErrorType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
