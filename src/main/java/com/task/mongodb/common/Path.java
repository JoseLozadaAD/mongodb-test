package com.task.mongodb.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Path {
  // Customer
  public static final String CUSTOMER = "api/customers";
  public static final String CUSTOMER_ID = CUSTOMER + "/{id}";
  public static final String CUSTOMER_CITY = CUSTOMER + "/city";
  // Sale
  public static final String SALE = "api/sales";
  public static final String SALE_ID = SALE + "/{id}";
  public static final String SALE_ITEM = "api/sales/item";
  public static final String SALE_ITEM_TOTAL = SALE_ITEM + "/total_amount";
  public static final String SALE_CUSTOMER_NAME = "api/sales/customer";
  public static final String SALE_CUSTOMER_NAME_TOTAL = SALE_CUSTOMER_NAME + "/total_amount";
}
