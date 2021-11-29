package com.inspo.solutions.inspoBrewery.web.controller;

import com.inspo.solutions.inspoBrewery.services.BeerService;
import com.inspo.solutions.inspoBrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping // -- create new beer
    public ResponseEntity handlePost(@RequestBody @Valid BeerDto beer){
        BeerDto beerDto = this.beerService.saveNewBear(beer);
        HttpHeaders header = new HttpHeaders();
        //TODO hostname to url
        header.set("Location", "/api/vi/beer/"+beerDto.getId().toString());
        return new ResponseEntity(header, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public  ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beer){
        this.beerService.updateBeer(beerId,beer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("beerId") UUID beerId){
        this.beerService.deleteBeerById(beerId);
    }
}
