package com.business.service;

import com.business.dao.CustomerDAO;
import com.business.domain.Customer;

import java.util.List;

public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    public void createCustomer(String firstName, String lastName, String email){
        customerDAO.create(new Customer(firstName, lastName, email));
    }

    public List<Customer> getCustomers(){
        return customerDAO.getAll();
    }

    public Customer getByEmail(String email){
        return customerDAO.getByEmail(email);

    }


}
