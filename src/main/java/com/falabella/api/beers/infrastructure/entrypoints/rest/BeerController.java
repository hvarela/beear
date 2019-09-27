package com.falabella.api.beers.infrastructure.entrypoints.rest;

import com.falabella.api.beers.domain.entities.beers.BeerItem;
import com.falabella.api.beers.domain.usecases.BeerOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/beers")
public class BeerController {

    private final BeerOperations beerOperations;

    public  BeerController(BeerOperations beerOperations){
        this.beerOperations = beerOperations;
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public Collection<BeerItem> searchBeers() {

        return beerOperations.getAllBeer();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public BeerItem searchBeers(@PathVariable int id) {

        return beerOperations.getBeerbyId( id);
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public BeerItem addBeers(@RequestBody BeerItem beerItem) {

        beerItem.validate();



        return beerOperations.addBeer(beerItem);
    }
}
