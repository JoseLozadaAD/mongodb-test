package com.task.mongodb.sales.adapter.out.persistence;

import com.task.mongodb.common.ErrorMessages;
import com.task.mongodb.common.Mapper;
import com.task.mongodb.common.PersistenceAdapter;
import com.task.mongodb.customer.adapter.out.persistence.model.CustomerEntity;
import com.task.mongodb.customer.adapter.out.persistence.repository.CustomerMongoRepository;
import com.task.mongodb.exceptions.EntityNotFoundException;
import com.task.mongodb.sales.adapter.out.persistence.model.SaleEntity;
import com.task.mongodb.sales.adapter.out.persistence.repository.SaleMongoRepository;
import com.task.mongodb.sales.application.out.FindSalesByCustomerNamePort;
import com.task.mongodb.sales.application.out.FindSalesByItemPort;
import com.task.mongodb.sales.application.out.SaveSalePort;
import com.task.mongodb.sales.domain.Sale;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class SaleDao implements
    SaveSalePort,
    FindSalesByItemPort,
    FindSalesByCustomerNamePort {
  private final SaleMongoRepository saleRepository;
  private final CustomerMongoRepository customerRepository;

  @Override
  public Sale save(Sale sale) {
    String customerId = sale.getCustomer().getId();
    Optional<CustomerEntity> customerFromDb = customerRepository.findById(customerId);

    if (customerFromDb.isEmpty()) {
      throw new EntityNotFoundException(String.format(ErrorMessages.CUSTOMER_BY_ID_NOT_FOUND, customerId));
    }

    SaleEntity saleEntity = saleRepository.save(Mapper.convert(sale, SaleEntity.class));

    return Mapper.convert(saleEntity, Sale.class);
  }

  @Override
  public List<Sale> findByItem(String item) {
    List<SaleEntity> salesFromDb = saleRepository.findByItem(item);

    if (salesFromDb.isEmpty()) {
      throw new EntityNotFoundException(String.format(ErrorMessages.SALE_BY_ITEM_NOT_FOUND, item));
    }

    return Mapper.convertAll(salesFromDb, Sale.class);
  }

  @Override
  public List<Sale> findByCustomerName(String name) {
    List<CustomerEntity> customerFromDb = customerRepository.findByCompleteName(name);
    List<String> ids = customerFromDb.stream().map(CustomerEntity::getId).toList();
    List<SaleEntity> salesFromDb = new ArrayList<>();
    ids.forEach(id -> salesFromDb.addAll(saleRepository.findByCustomerId(id)));

    if (salesFromDb.isEmpty()) {
      throw new EntityNotFoundException(String.format(ErrorMessages.SALE_BY_CUSTOMER_NAME_NOT_FOUND, name));
    }

    return Mapper.convertAll(salesFromDb, Sale.class);
  }
}
