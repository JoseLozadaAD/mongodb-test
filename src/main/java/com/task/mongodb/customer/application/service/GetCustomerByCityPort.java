package com.task.mongodb.customer.application.service;

import com.task.mongodb.common.UseCase;
import com.task.mongodb.customer.application.in.GetCustomerByCityQuery;
import com.task.mongodb.customer.application.out.FindCustomerByCityPort;
import com.task.mongodb.customer.domain.Customer;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetCustomerByCityPort implements GetCustomerByCityQuery {
  private final FindCustomerByCityPort customerPort;

  @Override
  public List<Customer> getByCity(String city) {
    return customerPort.findByCity(city);
  }
}
