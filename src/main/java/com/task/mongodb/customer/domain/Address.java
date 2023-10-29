package com.task.mongodb.customer.domain;

import lombok.*;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
  private String city;
  private String zone;
  private String street;
}
