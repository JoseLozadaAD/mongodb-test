package com.task.mongodb.sales.application.service;

import com.task.mongodb.common.Messages;
import com.task.mongodb.common.UseCase;
import com.task.mongodb.sales.application.in.GetSalesByItemQuery;
import com.task.mongodb.sales.application.out.FindSalesByItemPort;
import com.task.mongodb.sales.domain.Sale;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.DoubleStream;

@UseCase
@RequiredArgsConstructor
public class GetSaleByItemService implements GetSalesByItemQuery {
  private final FindSalesByItemPort salesPort;

  @Override
  public List<Sale> getByItem(String item) {
    return salesPort.findByItem(item);
  }

  @Override
  public String getSumByItem(String item) {
    List<Sale> sales = salesPort.findByItem(item);
    double totalAmount = sales.stream()
        .flatMapToDouble(sale -> DoubleStream.of(sale.getAmount())).sum();

    return String.format(Messages.TOTAL_AMOUNT_BY_ITEM, item, (float) totalAmount);
  }
}
