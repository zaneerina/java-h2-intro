package com.business.dao;

import com.business.domain.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class CustomerDAO {
    // customer data access object is currently doing nothing but it will use H2

    /**
     * Variables for database connection; JDBC url specifies how we are connection to h2 database;
     * There's no information of communication protocol indicating that the db is embedded inside the app process
     * DB_CLOSE_DELAY needs to be set to -1; otherwise h2 will lose the content
     * of the database after the last connection is closed. With -1  h2 will keep the data until the process exits
     * This connection will create a table called test
     */

    private static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String CREATE_TABLE_SQL = "CREATE TABLE Customer(" +
            "id bigint auto_increment PRIMARY KEY," +
            "firstname varchar(20),"+
            "lastname varchar(256),"+
            "email varchar (265),"+
            "UNIQUE(email))"; // uniqueness constraint on the email

    public void create(Customer customer){

    }
    public List<Customer> getAll(){
        return Arrays.asList();
    }

    public Customer getByEmail (String email){
        return null;
    }

    public void createTable() throws SQLException {
        // JDBC is the simplest way to interact with any relational database management system (inc.H2) via SQL

        // get a connection via driver manager:
//        Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD); --> catch exception:
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // creation of statement that will be used by h2 when we'll send create table request
            Statement statement = connection.createStatement();
            statement.executeUpdate(CREATE_TABLE_SQL);
        }
    }
}
