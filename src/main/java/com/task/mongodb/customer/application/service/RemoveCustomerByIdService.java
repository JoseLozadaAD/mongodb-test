package com.task.mongodb.customer.application.service;

import com.task.mongodb.common.UseCase;
import com.task.mongodb.customer.application.in.RemoveCustomerByIdUseCase;
import com.task.mongodb.customer.application.out.DeleteCustomerByIdPort;
import com.task.mongodb.customer.domain.Customer;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class  RemoveCustomerByIdService implements RemoveCustomerByIdUseCase {
  private final DeleteCustomerByIdPort customerPort;

  @Override
  public Customer removeById(String id) {
    return customerPort.deleteById(id);
  }
}
