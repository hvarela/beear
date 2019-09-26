package com.falabella.api.beers.infrastructure.configuration;

import com.falabella.api.beers.domain.usecases.BeerOperations;
import com.falabella.api.beers.infrastructure.entrypoints.rest.repository.BeerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration{

    BeerRepository beerRepository;

    public SpringConfiguration(BeerRepository beerRepository){
        this.beerRepository = beerRepository;
    }

    @Bean
    public BeerOperations getBeerOperations(){
        return new BeerOperations(beerRepository);
    }
}
