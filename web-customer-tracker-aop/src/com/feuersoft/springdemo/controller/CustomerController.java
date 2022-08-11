package com.feuersoft.springdemo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.feuersoft.springdemo.entity.Customer;
import com.feuersoft.springdemo.service.CustomerService;
import com.feuersoft.springdemo.util.SortUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {
  
  // Not needed anymore because the service is doing it.
  // @Autowired
  // private CustomerDAO customerDAO;
  
  // Need to inject the customer service
  @Autowired
  private CustomerService customerService;
  
  @GetMapping("/list")
  public String listCustomers(Model theModel, @RequestParam(required=false) String sort) {
    
    // get customers from dao
    //List<Customer> theCustomers = customerService.getCustomers();
    List<Customer> theCustomers = null;
    
    // check for sort field
    if (null != sort) {
     int theSortField = Integer.parseInt(sort);
     theCustomers = customerService.getCustomers(theSortField);   
    }
    else {
     // no sort field provided ... default to sorting by last name
     theCustomers = customerService.getCustomers(SortUtils.LAST_NAME);
    }    
    
    // add the customers to the model
    theModel.addAttribute("customers", theCustomers);
    
    // This is in reference to the list-customers.jsp
    return "list-customers";
  }
  
  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model theModel) {
    
    Customer theCustomer = new Customer();
    
    theModel.addAttribute("customer", theCustomer);
    
    return "customer-form";
  }
  
  @PostMapping("/saveCustomer")
  public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
    
    // Save the customer data using the service
    customerService.saveCustomer(theCustomer);
    
    // Return back to the customer list
    return "redirect:/customer/list";
  }
  
  @GetMapping("/showFormForUpdate")
  public String showFormForUpdate(@RequestParam("customerId") int theId, 
                                  Model theModel) {
        
    // get the Customer from the database
    Customer theCustomer = customerService.getCustomer(theId);
    
    // set customer as a model attribute to pre-populate the form
    theModel.addAttribute("customer", theCustomer);
    
    // send over to our form
    return "customer-form";
    
  }
  
  
  @GetMapping("/delete")
  public String deleteCustomer(@RequestParam("customerId") int theId) {
    
    // delete the customer
    customerService.deleteCustomer(theId);
    
    return "redirect:/customer/list";
  
  }
  
  @GetMapping("/search")
  public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                  Model theModel) {
      // search customers from the service
      List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
              
      // add the customers to the model
      theModel.addAttribute("customers", theCustomers);
      return "list-customers";        
  }  
  
}
