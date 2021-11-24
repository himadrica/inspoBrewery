package com.inspo.solutions.inspoBrewery.services;

import com.inspo.solutions.inspoBrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
    CustomerDto saveCustomer(CustomerDto customerDto);
    void updateCustomer(UUID customerId, CustomerDto customerDto);
    void deleteCustomerById(UUID customerId);
}
