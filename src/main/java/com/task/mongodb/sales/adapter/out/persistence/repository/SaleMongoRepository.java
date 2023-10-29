package com.task.mongodb.sales.adapter.out.persistence.repository;

import com.task.mongodb.sales.adapter.out.persistence.model.SaleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleMongoRepository extends MongoRepository<SaleEntity, String> {
  List<SaleEntity> findByItem(String item);

  @Query("{'customer.id': {$in: ?0}}")
  List<SaleEntity> findByCustomerIds(List<String> ids);

  List<SaleEntity> findByCustomerId(String id);
}
