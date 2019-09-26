package com.falabella.api.beers.infrastructure.entrypoints.rest;

import com.falabella.api.beers.domain.entities.beers.BeerItem;
import com.falabella.api.beers.domain.usecases.BeerOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/beers/")
public class BeerController {

    private final BeerOperations beerOperations;

    public  BeerController(BeerOperations beerOperations){
        this.beerOperations = beerOperations;
    }

    @GetMapping()
    public String searchBeers() {

        beerOperations.getAllBeer();

        return String.format("Echo [%s]",  "exito");
    }

    @PostMapping()
    public String addBeers( ) {

        beerOperations.addBeer( new BeerItem(1,"tito","casa de beeer","CL",10, "CLP"));

        return String.format("add  ok [%s]",  "exito");
    }
}
