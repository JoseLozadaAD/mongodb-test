package com.task.mongodb.sales.application.in;

import com.task.mongodb.sales.domain.Sale;

import java.util.List;

public interface GetSalesByCustomerNameQuery {
  List<Sale> getByCompleteName(String name);
  String getSumByCompleteName(String name);
}
