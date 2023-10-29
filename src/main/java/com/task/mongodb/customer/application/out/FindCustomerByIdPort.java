package com.task.mongodb.customer.application.out;

import com.task.mongodb.customer.adapter.out.persistence.model.CustomerEntity;

@FunctionalInterface
public interface FindCustomerByIdPort {
  CustomerEntity findById(String id);
}
