package com.stpunk47.customerdemo.service;

import com.stpunk47.customerdemo.model.Customer;
import com.stpunk47.customerdemo.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getById(Long id) {
        log.info("In CustomerServiceImpl getById() ID: ", id);
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCustomer(Customer customer) {
        log.info("In CustomerServiceImpl save() ID: ", customer);
        customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        log.info("In CustomerServiceImpl delete() ID: ", id);
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        log.info("In CustomerServiceImpl getAll() ");
        return customerRepository.findAll();
    }
}
