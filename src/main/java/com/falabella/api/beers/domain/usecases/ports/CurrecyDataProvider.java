package com.falabella.api.beers.domain.usecases.ports;

public interface CurrecyDataProvider {
    Float getCurrencyConverionRate(String source, String destination);
}
