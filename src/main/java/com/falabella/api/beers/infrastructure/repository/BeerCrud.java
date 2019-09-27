package com.falabella.api.beers.infrastructure.repository;

import com.falabella.api.beers.infrastructure.entities.BeersEntity;
import org.springframework.data.repository.CrudRepository;

public interface BeerCrud extends CrudRepository<BeersEntity, Integer> {

}