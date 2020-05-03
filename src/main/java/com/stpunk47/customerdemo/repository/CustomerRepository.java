package com.stpunk47.customerdemo.repository;

import com.stpunk47.customerdemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
