package com.falabella.api.beers.infrastructure.configuration;

import com.falabella.api.beers.domain.usecases.BeerOperations;
import com.falabella.api.beers.infrastructure.repository.BeerRepository;
import com.falabella.api.beers.infrastructure.repository.CurrencyRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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
