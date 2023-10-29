package com.task.mongodb.sales.application.service;

import com.task.mongodb.common.UseCase;
import com.task.mongodb.sales.application.in.RegisterSaleUseCase;
import com.task.mongodb.sales.application.out.SaveSalePort;
import com.task.mongodb.sales.domain.Sale;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@UseCase
@RequiredArgsConstructor
public class RegisterSaleService implements RegisterSaleUseCase {
  private final SaveSalePort salePort;

  @Override
  public Sale register(Sale sale) {
    sale.setCreatedAt(new Date());

    return salePort.save(sale);
  }
}
