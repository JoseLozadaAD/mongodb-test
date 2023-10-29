package com.task.mongodb.customer.adapter.in.web;

import com.task.mongodb.common.Path;
import com.task.mongodb.common.WebAdapter;
import com.task.mongodb.customer.application.in.GetAllCustomersQuery;
import com.task.mongodb.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetAllCustomersController {
  private final GetAllCustomersQuery customersQuery;

  @GetMapping(Path.CUSTOMER)
  public ResponseEntity<Iterable<Customer>> findAll() {
    return ResponseEntity.ok(customersQuery.getAll());
  }
}
