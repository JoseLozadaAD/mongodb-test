package com.task.mongodb.customer.application.out;

import com.task.mongodb.customer.domain.Customer;

@FunctionalInterface
public interface DeleteCustomerByIdPort {
  Customer deleteById(String id);
}
