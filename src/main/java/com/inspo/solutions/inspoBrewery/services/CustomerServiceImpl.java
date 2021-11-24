package com.inspo.solutions.inspoBrewery.services;

import com.inspo.solutions.inspoBrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto
                .builder()
                .id(UUID.randomUUID())
                .name("Abhik")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Jaysen")
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.debug("updating customer " + customerId.toString());
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
    log.debug("deleting customer " + customerId.toString());
    }
}
