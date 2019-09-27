package com.falabella.api.beers.infrastructure.repository;

import com.falabella.api.beers.domain.entities.error.ApiCurrencyException;
import com.falabella.api.beers.domain.usecases.ports.CurrecyDataProvider;
import com.falabella.api.beers.infrastructure.entities.CurrencylayerDTO;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Repository
public class CurrencyRepository implements CurrecyDataProvider {

    Logger  logger = LoggerFactory.getLogger( CurrencyRepository.class);

    RestTemplate restTemplate;

    private final String HOST="http://apilayer.net";
    private final String PATH="/api/live";
    @Value("${currency.access_key}")
    private String access_key;

    public CurrencyRepository(){
        restTemplate = new RestTemplate();
    }


    @Override
    public Float getCurrencyConverionRate(String source, String destination) {

        String url = genereURL(source,destination);
        logger.info("consultando conversion url: " + url );
        ResponseEntity<CurrencylayerDTO> response  = restTemplate.getForEntity( url, CurrencylayerDTO.class);

        return  getRate( response.getBody());


    }

    private Float getRate(CurrencylayerDTO currencylayerDTO) {

        if( currencylayerDTO.isSuccess()){

            Map.Entry<String,Float> entry =  currencylayerDTO.getQuotes().entrySet().iterator().next();
            return entry.getValue();

        }else{
            logger.error( String.format( "error code [%d]  msg [%s]", currencylayerDTO.getError().getCode(), currencylayerDTO.getError().getInfo()));
            throw new ApiCurrencyException();
        }
    }

    private String genereURL( String source, String destination){
        return String.format("%s%s?access_key=%s&format=1&currencies=%s&source=%s",HOST,PATH,access_key, destination,source);
    }
}
