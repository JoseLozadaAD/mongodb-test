package com.task.mongodb.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Messages {
  public static final String TOTAL_AMOUNT_BY_ITEM = "ITEM: %s\ntotal amount: %f";
  public static final String TOTAL_AMOUNT_BY_CUSTOMER_NAME = "CUSTOMER: %s\ntotal amount: %f";
}
