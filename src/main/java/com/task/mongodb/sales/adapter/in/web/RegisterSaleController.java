package com.task.mongodb.sales.adapter.in.web;

import com.task.mongodb.common.Path;
import com.task.mongodb.common.WebAdapter;
import com.task.mongodb.sales.application.in.RegisterSaleUseCase;
import com.task.mongodb.sales.domain.Sale;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterSaleController {
  private final RegisterSaleUseCase saleUseCase;

  @PostMapping(Path.SALE)
  public ResponseEntity<Sale> save(@RequestBody Sale sale){
    return ResponseEntity.ok(saleUseCase.register(sale));
  }
}
