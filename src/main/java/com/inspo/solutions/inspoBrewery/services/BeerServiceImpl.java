package com.inspo.solutions.inspoBrewery.services;

import com.inspo.solutions.inspoBrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Corona extra")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBear(BeerDto beer) {
        return BeerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beer) {
        log.debug("updating beer by id " + beerId);
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("deleting beer by id " + beerId);
    }
}
