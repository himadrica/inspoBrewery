package com.inspo.solutions.inspoBrewery.web.controller.v2;

import com.inspo.solutions.inspoBrewery.services.v2.BeerServiceV2;
import com.inspo.solutions.inspoBrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {
    private final BeerServiceV2 beerService;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping // -- create new beer
    public ResponseEntity handlePost(@RequestBody BeerDtoV2 beer){
        BeerDtoV2 beerDto = this.beerService.saveNewBear(beer);
        HttpHeaders header = new HttpHeaders();
        //TODO hostname to url
        header.set("Location", "/api/vi/beer/"+beerDto.getId().toString());
        return new ResponseEntity(header, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public  ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beer){
        this.beerService.updateBeer(beerId,beer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("beerId") UUID beerId){
        this.beerService.deleteBeerById(beerId);
    }
}
