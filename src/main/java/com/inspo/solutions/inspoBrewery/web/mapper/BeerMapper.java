package com.inspo.solutions.inspoBrewery.web.mapper;

import com.inspo.solutions.inspoBrewery.domain.Beer;
import com.inspo.solutions.inspoBrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto dto);
}
