package com.stpunk47.customerdemo.rest;


import com.stpunk47.customerdemo.model.Customer;
import com.stpunk47.customerdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/customers/")
public class CustomerRestControllerV1 {

    private final CustomerService customerService;

    public CustomerRestControllerV1(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId){
        if(customerId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Customer customer = this.customerService.getById(customerId);

        if(customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    public ResponseEntity<Customer> saveCustomer(Customer customer){
        HttpHeaders headers = new HttpHeaders();

        if(customer == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.customerService.saveCustomer(customer);

        return new ResponseEntity<>(customer, headers, HttpStatus.CREATED);
    }

}
