package com.inspo.solutions.inspoBrewery.services;

import com.inspo.solutions.inspoBrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
    BeerDto saveNewBear(BeerDto beer);
    void updateBeer(UUID beerId, BeerDto beer);
    void deleteBeerById(UUID beerId);
}
