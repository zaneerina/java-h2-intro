package com.business.domain;
public class Customer {
    //the class encapsulates customer data - name, lastname & email
    /* ljoti svarigas koda rindas ./...
    asasadsf

    sfdsfdsfgdg
    dfg
    dfgfhsf
    hsfhfshjasdjhsjhfjdsfhjjsfjksjf
     */
    private final String firstName;
    private final String lastName;
    private final String email;

    public Customer (String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email  = email;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String toString (){
        return String.format(
                "Customer [firstName=%s; lastName=%s; email=%s ]", firstName, lastName, email);
    }
}