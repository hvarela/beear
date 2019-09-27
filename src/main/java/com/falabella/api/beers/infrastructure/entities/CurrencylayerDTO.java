package com.falabella.api.beers.infrastructure.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;


@Getter
@Setter
public class CurrencylayerDTO implements Serializable {
    boolean success;
    String terms;
    String privacy;
    long timestamp;
    HashMap<String, Float> quotes;
    ErrorDTO  error;
}
