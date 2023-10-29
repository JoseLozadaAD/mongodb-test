package com.task.mongodb.customer.adapter.in.web;

import com.task.mongodb.common.Path;
import com.task.mongodb.common.WebAdapter;
import com.task.mongodb.customer.application.in.GetCustomerByCityQuery;
import com.task.mongodb.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetCustomerByCityController {
  private final GetCustomerByCityQuery customerQuery;

  @GetMapping(Path.CUSTOMER_CITY)
  public ResponseEntity<Iterable<Customer>> getByCity(@RequestParam(name = "city") String city) {
    return ResponseEntity.ok(customerQuery.getByCity(city));
  }
}
