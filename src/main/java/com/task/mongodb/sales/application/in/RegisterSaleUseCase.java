package com.task.mongodb.sales.application.in;

import com.task.mongodb.sales.domain.Sale;

@FunctionalInterface
public interface RegisterSaleUseCase {
  Sale register(Sale sale);
}
