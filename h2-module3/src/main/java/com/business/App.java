package com.business;

import com.business.dao.CustomerDAO;
import com.business.domain.Customer;
import com.business.service.CustomerService;

import java.sql.SQLException;


public class App {

    private static final String THEO = "Theo";
    private static final String LEDGER = "Ledger";
    private static final String THEO_LEDGER_EMAIL = "theo.ledger@business.com";
    private static final String JESSICA = "Jessica";
    private static final String CORINO = "Corino";
    private static final String JESSICA_CORINO_EMAIL = "jessica.corino@business.com";

    //instantiate a new customer service object using customer DAO
    private static final CustomerService customerService = new CustomerService(new CustomerDAO());

    public static void main(String[] args) throws SQLException {
        customerService.CreateCustomerTable();
        customerService.createCustomer(THEO, LEDGER, THEO_LEDGER_EMAIL);
        customerService.createCustomer(JESSICA, CORINO, JESSICA_CORINO_EMAIL);
        printAllCustomers();
        printCustomerByEmail(JESSICA_CORINO_EMAIL);
        printCustomerByEmail(THEO_LEDGER_EMAIL);
    }

    private static void printAllCustomers() throws SQLException {
        System.out.println("printing all customers...");
        customerService.getCustomers().
                forEach(System.out::println);
    }
    private static void printCustomerByEmail(String email) throws SQLException {
        System.out.println("Printing customers by email...");
        System.out.println(customerService.getByEmail(email));
    }

}
