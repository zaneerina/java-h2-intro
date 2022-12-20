package com.business.dao;

import com.business.domain.Customer;

import java.util.Arrays;
import java.util.List;

public class CustomerDAO {
    // customer data access object is currently doing nothing but it will use H2

    public void create(Customer customer){

    }
    public List<Customer> getAll(){
        return Arrays.asList();
    }

    public Customer getByEmail (String email){
        return null;
    }
}
