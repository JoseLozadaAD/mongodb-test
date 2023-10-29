package com.task.mongodb.customer.application.service;

import com.task.mongodb.common.UseCase;
import com.task.mongodb.customer.application.in.RegisterCustomerUseCase;
import com.task.mongodb.customer.application.out.SaveCustomerPort;
import com.task.mongodb.customer.domain.Customer;

import lombok.RequiredArgsConstructor;

import java.util.Date;

@UseCase
@RequiredArgsConstructor
public class RegisterCustomerService implements RegisterCustomerUseCase {
  private final SaveCustomerPort customerPort;

  @Override
  public Customer register(Customer customer) {
    customer.setCreatedAt(new Date());
    customer.setCompleteName(customer.getFirstName() + " " + customer.getLastName());

    return customerPort.save(customer);
  }
}
