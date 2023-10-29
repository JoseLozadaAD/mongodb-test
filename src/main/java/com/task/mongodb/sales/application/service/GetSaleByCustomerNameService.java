package com.task.mongodb.sales.application.service;

import com.task.mongodb.common.Messages;
import com.task.mongodb.common.UseCase;
import com.task.mongodb.sales.application.in.GetSalesByCustomerNameQuery;
import com.task.mongodb.sales.application.out.FindSalesByCustomerNamePort;
import com.task.mongodb.sales.domain.Sale;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.DoubleStream;

@UseCase
@RequiredArgsConstructor
public class GetSaleByCustomerNameService implements GetSalesByCustomerNameQuery {
  private final FindSalesByCustomerNamePort salesPort;

  @Override
  public List<Sale> getByCompleteName(String name) {
    return salesPort.findByCustomerName(name);
  }

  @Override
  public String getSumByCompleteName(String name) {
    List<Sale> sales = salesPort.findByCustomerName(name);
    double totalAmount = sales.stream()
        .flatMapToDouble(sale -> DoubleStream.of(sale.getAmount())).sum();

    return String.format(Messages.TOTAL_AMOUNT_BY_CUSTOMER_NAME, name, (float) totalAmount);
  }
}
