package com.task.mongodb.customer.application.in;

import com.task.mongodb.customer.domain.Customer;

@FunctionalInterface
public interface RegisterCustomerUseCase {
  Customer register(Customer customer);
}
