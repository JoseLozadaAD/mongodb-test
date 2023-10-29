package com.task.mongodb.customer.application.in;

import com.task.mongodb.customer.domain.Customer;

import java.util.List;

@FunctionalInterface
public interface GetAllCustomersQuery {
  List<Customer> getAll();
}
