package com.task.mongodb.customer.adapter.out.persistence.repository;

import com.task.mongodb.customer.adapter.out.persistence.model.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMongoRepository extends MongoRepository<CustomerEntity, String> {
  List<CustomerEntity> findByAddressCity(String city);
  List<CustomerEntity> findByCompleteName(String completeName);
}
