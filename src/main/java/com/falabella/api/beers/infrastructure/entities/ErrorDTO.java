package com.falabella.api.beers.infrastructure.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ErrorDTO implements Serializable {
    int code;
    String info;
}
