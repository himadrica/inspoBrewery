package com.inspo.solutions.inspoBrewery.web.controller;

import com.inspo.solutions.inspoBrewery.services.CustomerService;
import com.inspo.solutions.inspoBrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = this.customerService.saveCustomer(customerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Location", "/api/v1/customer/" + savedCustomer.getId().toString());

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto){
        this.customerService.updateCustomer(customerId, customerDto);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable("customerId") UUID customerId){
        this.customerService.deleteCustomerById(customerId);
    }
}
