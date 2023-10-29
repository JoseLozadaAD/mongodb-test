package com.task.mongodb.customer.adapter.out.persistence.model;

import com.task.mongodb.customer.domain.Address;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customer")
public class CustomerEntity {
  @Id
  private String id;
  private String firstName;
  private String lastName;
  private String completeName;
  private String phone;
  private Address address;
  private Date createdAt;
}
