package com.task.mongodb.sales.domain;

import com.task.mongodb.customer.domain.Customer;
import lombok.*;

import java.util.Date;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
  private String id;
  private Customer customer;
  private String item;
  private float amount;
  private Date createdAt;
}
