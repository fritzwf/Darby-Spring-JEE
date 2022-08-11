package com.feuersoft.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.feuersoft.springdemo.dao.CustomerDAO;
import com.feuersoft.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

  // need to inject customer dao
  @Autowired
  private CustomerDAO customerDAO;
  
  @Override
  @Transactional
  public List<Customer> getCustomers(int theSortField) {
    return customerDAO.getCustomers(theSortField);
   }

  @Override
  @Transactional
  public void saveCustomer(Customer theCustomer) {
    customerDAO.saveCustomer(theCustomer);
  }

  @Override
  public Customer getCustomer(int theId) {
    return customerDAO.getCustomer(theId);
  }

  @Override
  @Transactional
  public void deleteCustomer(int theId) {
    customerDAO.deleteCustomer(theId);
  }

  @Override
  public List<Customer> searchCustomers(String theSearchName) {
    return customerDAO.searchCustomers(theSearchName);
  }

}
