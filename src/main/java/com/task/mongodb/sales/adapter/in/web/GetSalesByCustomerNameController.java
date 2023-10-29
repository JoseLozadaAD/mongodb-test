package com.task.mongodb.sales.adapter.in.web;

import com.task.mongodb.common.Path;
import com.task.mongodb.common.WebAdapter;
import com.task.mongodb.sales.application.in.GetSalesByCustomerNameQuery;
import com.task.mongodb.sales.domain.Sale;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetSalesByCustomerNameController {
  private final GetSalesByCustomerNameQuery salesQuery;

  @GetMapping(Path.SALE_CUSTOMER_NAME)
  public ResponseEntity<Iterable<Sale>> getByItem(@RequestParam(name = "name") String name) {
    return ResponseEntity.ok(salesQuery.getByCompleteName(name));
  }

  @GetMapping(Path.SALE_CUSTOMER_NAME_TOTAL)
  public ResponseEntity<String> getByItemTotal(@RequestParam(name = "name") String name) {
    return ResponseEntity.ok(salesQuery.getSumByCompleteName(name));
  }
}
