package com.task.mongodb.customer.application.in;

import com.task.mongodb.customer.domain.Customer;

@FunctionalInterface
public interface RemoveCustomerByIdUseCase {
  Customer removeById(String id);
}
