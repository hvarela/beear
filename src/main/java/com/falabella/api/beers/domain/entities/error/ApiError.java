package com.falabella.api.beers.domain.entities.error;

import java.util.Objects;
import java.util.StringJoiner;

public class ApiError {

    private String status;
    private String message;
    private String error;

    public ApiError() {
        // Default constructor
    }

    public ApiError(String httpStatus, String message, String error) {
        this.status = httpStatus;
        this.message = message;
        this.error =  error;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ApiError apiError = (ApiError) o;

        return  this.error == apiError.error &&
                this.message == apiError.message &&
                this.status == apiError.status;

    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "ApiError" + "[", "]")
                .add("status=" + status)
                .add("message='" + message + "'")
                .add("errors=" + error)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus());
    }
}
