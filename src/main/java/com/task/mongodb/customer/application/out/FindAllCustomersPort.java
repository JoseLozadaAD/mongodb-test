package com.task.mongodb.customer.application.out;

import com.task.mongodb.customer.domain.Customer;

import java.util.List;

@FunctionalInterface
public interface FindAllCustomersPort {
  List<Customer> findAll();
}
