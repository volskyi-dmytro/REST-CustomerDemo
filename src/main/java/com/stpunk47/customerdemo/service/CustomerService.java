package com.stpunk47.customerdemo.service;

import com.stpunk47.customerdemo.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(Long id);

    void saveCustomer(Customer customer);

    void deleteById(Long id);

    List<Customer> getAll();
}
