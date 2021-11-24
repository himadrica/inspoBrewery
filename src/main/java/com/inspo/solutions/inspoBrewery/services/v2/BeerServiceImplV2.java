package com.inspo.solutions.inspoBrewery.services.v2;

import com.inspo.solutions.inspoBrewery.web.model.v2.BeerDtoV2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImplV2 implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return null;
    }

    @Override
    public BeerDtoV2 saveNewBear(BeerDtoV2 beer) {
        return null;
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beer) {

    }

    @Override
    public void deleteBeerById(UUID beerId) {

    }
}
