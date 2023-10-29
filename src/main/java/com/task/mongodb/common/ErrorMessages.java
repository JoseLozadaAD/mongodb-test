package com.task.mongodb.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorMessages {
  public static final String CUSTOMERS_CITY_NOT_FOUND = "Customers with city '%s' not found";
  public static final String CUSTOMER_BY_ID_NOT_FOUND = "Customer with id '%s' not found";
  public static final String SALE_BY_ITEM_NOT_FOUND = "Sales with item '%s' not found";
  public static final String SALE_BY_CUSTOMER_NAME_NOT_FOUND = "Sales with customer name '%s' not found";
}
