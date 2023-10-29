package com.task.mongodb.customer.application.out;

import com.task.mongodb.customer.domain.Customer;

import java.util.List;

@FunctionalInterface
public interface FindCustomerByCityPort {
  List<Customer> findByCity(String city);
}
