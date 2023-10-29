package com.task.mongodb.sales.application.in;

import com.task.mongodb.sales.domain.Sale;

import java.util.List;

public interface GetSalesByItemQuery {
  List<Sale> getByItem(String item);
  String getSumByItem(String item);
}
