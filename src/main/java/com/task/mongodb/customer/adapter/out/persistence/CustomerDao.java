package com.task.mongodb.customer.adapter.out.persistence;

import com.task.mongodb.common.ErrorMessages;
import com.task.mongodb.common.Mapper;
import com.task.mongodb.common.PersistenceAdapter;
import com.task.mongodb.customer.adapter.out.persistence.model.CustomerEntity;
import com.task.mongodb.customer.adapter.out.persistence.repository.CustomerMongoRepository;
import com.task.mongodb.customer.application.out.*;
import com.task.mongodb.customer.domain.Customer;
import com.task.mongodb.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class CustomerDao implements
    SaveCustomerPort,
    FindCustomerByCityPort,
    DeleteCustomerByIdPort,
    FindCustomerByIdPort,
    FindAllCustomersPort {
  private final CustomerMongoRepository customerRepository;

  @Override
  public Customer save(Customer customer) {
    CustomerEntity customerEntity = customerRepository.save(Mapper.convert(customer, CustomerEntity.class));

    return Mapper.convert(customerEntity, Customer.class);
  }

  @Override
  public List<Customer> findByCity(String city) {
    List<CustomerEntity> customerEntityList = customerRepository.findByAddressCity(city);
    if (customerEntityList.size() == 0) {
      throw new EntityNotFoundException(String.format(ErrorMessages.CUSTOMERS_CITY_NOT_FOUND, city));
    }

    return Mapper.convertAll(customerEntityList, Customer.class);
  }

  @Override
  public Customer deleteById(String id) {
    CustomerEntity customerToDelete = findById(id);
    customerRepository.delete(customerToDelete);

    return Mapper.convert(customerToDelete, Customer.class);
  }

  @Override
  public CustomerEntity findById(String id) {
    Optional<CustomerEntity> customerFromDB = customerRepository.findById(id);

    if (customerFromDB.isEmpty()) {
      throw new EntityNotFoundException(String.format(ErrorMessages.CUSTOMER_BY_ID_NOT_FOUND, id));
    }

    return customerFromDB.get();
  }

  @Override
  public List<Customer> findAll() {
    return Mapper.convertAll(customerRepository.findAll(), Customer.class);
  }
}
