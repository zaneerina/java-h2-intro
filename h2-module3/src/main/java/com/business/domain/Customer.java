package com.business.domain;

public class Customer {
    //the class encapsulates the custoemr data - name, lastname & email
    private final String firstName;
    private final String lastName;
    private final String email;

    public Customer (String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email  = email;
    }

    public String toString (){
        return String.format(
                "Customer [firstName=%s; lastName=%s; email=%s ]", firstName, lastName, email);
    }


}
