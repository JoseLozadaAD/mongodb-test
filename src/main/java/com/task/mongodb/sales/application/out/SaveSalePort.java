package com.task.mongodb.sales.application.out;

import com.task.mongodb.sales.domain.Sale;

@FunctionalInterface
public interface SaveSalePort {
  Sale save(Sale sale);
}
