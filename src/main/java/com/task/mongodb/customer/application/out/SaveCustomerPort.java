package com.task.mongodb.customer.application.out;

import com.task.mongodb.customer.domain.Customer;

@FunctionalInterface
public interface SaveCustomerPort {
  Customer save(Customer customer);
}
