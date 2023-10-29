package com.task.mongodb.customer.application.service;

import com.task.mongodb.common.UseCase;
import com.task.mongodb.customer.application.in.GetAllCustomersQuery;
import com.task.mongodb.customer.application.out.FindAllCustomersPort;
import com.task.mongodb.customer.domain.Customer;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetAllCustomersService implements GetAllCustomersQuery {
  private final FindAllCustomersPort customersPort;

  @Override
  public List<Customer> getAll() {
    return customersPort.findAll();
  }
}
