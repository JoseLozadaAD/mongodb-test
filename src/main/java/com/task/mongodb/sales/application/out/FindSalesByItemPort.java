package com.task.mongodb.sales.application.out;

import com.task.mongodb.sales.domain.Sale;

import java.util.List;

@FunctionalInterface
public interface FindSalesByItemPort {
  List<Sale> findByItem(String item);
}
