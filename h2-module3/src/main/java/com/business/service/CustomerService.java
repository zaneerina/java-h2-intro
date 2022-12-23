package com.business.service;

import com.business.dao.CustomerDAO;
import com.business.domain.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    public void createCustomer(String firstName, String lastName, String email) throws SQLException {
        customerDAO.create(new Customer(firstName, lastName, email));
    }

    public List<Customer> getCustomers() throws SQLException {
        return customerDAO.getAll();
    }

    public Customer getByEmail(String email){
        return customerDAO.getByEmail(email);

    }


    public void CreateCustomerTable() throws SQLException {
        //customer DAO will be used to implement the actual creation of the table
        customerDAO.createTable();
    }
}
