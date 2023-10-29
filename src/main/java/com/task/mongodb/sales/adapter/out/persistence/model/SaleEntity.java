package com.task.mongodb.sales.adapter.out.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.task.mongodb.customer.adapter.out.persistence.model.CustomerEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "sales")
public class SaleEntity {
  @Id
  private String id;
  @DBRef
  private CustomerEntity customer;
  private String item;
  private float amount;
  private Date createdAt;
}
