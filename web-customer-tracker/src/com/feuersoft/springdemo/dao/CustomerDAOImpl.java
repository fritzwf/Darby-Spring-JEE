package com.feuersoft.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.feuersoft.springdemo.entity.Customer;
import com.feuersoft.springdemo.util.SortUtils;


// Need the @Repository annotation for the component scan to find this repository
// and handle the exception translation for us.
@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

  // need to inject the session @Autowired will automagically do it for us
  @Autowired
  private SessionFactory sessionFactory;
  
  @Override
//@Transactional not needed because the service is doing it instead.
  public List<Customer> getCustomers(int theSortField) {
   
   // get the current hibernate session
   Session currentSession = sessionFactory.getCurrentSession();
     
   // determine sort field
   String theFieldName = null;
   
   switch (theSortField) {
    case SortUtils.FIRST_NAME: 
     theFieldName = "firstName";
     break;
    case SortUtils.LAST_NAME:
     theFieldName = "lastName";
     break;
    case SortUtils.EMAIL:
     theFieldName = "email";
     break;
    default:
     // if nothing matches the default to sort by lastName
     theFieldName = "lastName";
   }
   
   // create a query  
   String queryString = "from Customer order by " + theFieldName;
   Query<Customer> theQuery = 
     currentSession.createQuery(queryString, Customer.class);
   
   // execute query and get result list
   List<Customer> customers = theQuery.getResultList();
     
   // return the results  
   return customers;
  }  
  

  @Override
  public void saveCustomer(Customer theCustomer) {
    
    // get current hibernate session
    Session currentSession = sessionFactory.getCurrentSession();
    
    // save the customer ... finally LOL
    currentSession.saveOrUpdate(theCustomer);
    
  }

  @Override
  public Customer getCustomer(int theId) {
    
    // get the current hibernate session
    Session currentSession = sessionFactory.getCurrentSession();
    
    // then retrieve/read from database using the primary key
    Customer theCustomer = currentSession.get(Customer.class, theId);
    
    return theCustomer;
  }

  @Override
  public void deleteCustomer(int theId) {
    
    // get the current hibernate session
    Session currentSession = sessionFactory.getCurrentSession();
    
    // delete object from the database using the primay key
    Query theQuery = 
        currentSession.createQuery("delete from Customer where id=:customerId");
    theQuery.setParameter("customerId", theId);
    
    theQuery.executeUpdate();
    
  }

  @Override
  public List<Customer> searchCustomers(String theSearchName) {
    // get the current hibernate session
    Session currentSession = sessionFactory.getCurrentSession();
    
    Query theQuery = null;
    
    //
    // only search by name if theSearchName is not empty
    //                                     from Customer order by lastName
    if (theSearchName != null && theSearchName.trim().length() > 0) {
        // search for firstName or lastName ... case insensitive
        theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName order by lastName", Customer.class);
        theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
    }
    else {
        // theSearchName is empty ... so just get all customers
        theQuery =currentSession.createQuery("from Customer", Customer.class);            
    }
    
    // execute query and get result list
    List<Customer> customers = theQuery.getResultList();
            
    // return the results        
    return customers;
  }

}
