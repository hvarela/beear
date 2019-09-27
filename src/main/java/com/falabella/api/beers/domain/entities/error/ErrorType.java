package com.falabella.api.beers.domain.entities.error;

public enum ErrorType {

    UNEXPECTED_ERROR("TKT0001", "Unexpected error"),
    BEER_INVALID_PARAMETE("TKT0002", "Request invalida"),
    BEERID_DUPLICATE("TKT0003", "El ID de la cerveza ya existe"),
    BEERID_NOT_FOUND("TKT0004", "El Id de la cerveza no existe"),
    CURRENCY_SERVER_ERROR("TKT0005", "Error al convertir moneda");

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
