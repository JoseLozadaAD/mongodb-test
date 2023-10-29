package com.task.mongodb.customer.domain;

import lombok.*;

import java.util.Date;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
  private String id;
  private String firstName;
  private String lastName;
  private String completeName;
  private String phone;
  private Address address;
  private Date createdAt;
}
