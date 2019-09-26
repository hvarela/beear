package com.falabella.api.beers.domain.entities.error;

public class InternalErrorException extends RuntimeException {

    private final ErrorType errorType;

    public InternalErrorException(String message) {
        this(ErrorType.UNEXPECTED_ERROR, message);
    }

    public InternalErrorException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public InternalErrorException(ErrorType errorType, String message, Exception exception) {
        super(message, exception);
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

}
