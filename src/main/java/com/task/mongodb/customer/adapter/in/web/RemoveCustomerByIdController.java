package com.task.mongodb.customer.adapter.in.web;

import com.task.mongodb.common.Path;
import com.task.mongodb.common.WebAdapter;
import com.task.mongodb.customer.application.in.RemoveCustomerByIdUseCase;
import com.task.mongodb.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RemoveCustomerByIdController {
  private final RemoveCustomerByIdUseCase customerUseCase;

  @DeleteMapping(Path.CUSTOMER_ID)
  public ResponseEntity<Customer> deleteById(@PathVariable String id) {
    return ResponseEntity.ok(customerUseCase.removeById(id));
  }
}
