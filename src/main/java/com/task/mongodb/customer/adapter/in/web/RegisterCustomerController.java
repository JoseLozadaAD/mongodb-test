package com.task.mongodb.customer.adapter.in.web;

import com.task.mongodb.common.Path;
import com.task.mongodb.common.WebAdapter;
import com.task.mongodb.customer.application.in.RegisterCustomerUseCase;
import com.task.mongodb.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterCustomerController {
  private final RegisterCustomerUseCase customerUseCase;

  @PostMapping(Path.CUSTOMER)
  public ResponseEntity<Customer> register(@RequestBody Customer customer) {
    return ResponseEntity.ok(customerUseCase.register(customer));
  }
}
