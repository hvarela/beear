package com.falabella.api.beers.infrastructure.repository;

import com.falabella.api.beers.domain.entities.beers.BeerItem;
import com.falabella.api.beers.domain.entities.error.BeerNotFoundException;
import com.falabella.api.beers.domain.entities.error.DuplicateBeerItemException;
import com.falabella.api.beers.domain.usecases.ports.BeerDataProvider;
import com.falabella.api.beers.domain.usecases.ports.CurrecyDataProvider;
import com.falabella.api.beers.infrastructure.entities.BeersEntity;
import com.falabella.api.beers.infrastructure.repository.translate.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class CurrencyRepository implements CurrecyDataProvider {

    @Override
    public Float getCurrencyConverionRate(String source, String destination) {
        return new Float(700.0);
    }
}
