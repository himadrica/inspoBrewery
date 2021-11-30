package com.inspo.solutions.inspoBrewery.web.mapper;

import com.inspo.solutions.inspoBrewery.domain.Customer;
import com.inspo.solutions.inspoBrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDto customerDto);
    CustomerDto customerToCustomerDto(Customer customer);
}
