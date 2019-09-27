package com.falabella.api.beers.infrastructure.configuration;

import com.falabella.api.beers.domain.usecases.BeerOperations;
import com.falabella.api.beers.infrastructure.repository.BeerRepository;
import com.falabella.api.beers.infrastructure.repository.CurrencyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration{

    BeerRepository beerRepository;
    CurrencyRepository currencyRepository;

    public SpringConfiguration(BeerRepository beerRepository, CurrencyRepository currencyRepository){
        this.beerRepository = beerRepository;
        this.currencyRepository  = currencyRepository;
    }

    @Bean
    public BeerOperations getBeerOperations(){
        return new BeerOperations(beerRepository, currencyRepository);
    }
}
