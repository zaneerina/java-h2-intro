package com.business.dao;

import com.business.domain.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    /**
     * Variables for database connection; JDBC url specifies how we are connection to h2 database;
     * There's no information of communication protocol indicating that the db is embedded inside the app process
     * DB_CLOSE_DELAY needs to be set to -1; otherwise h2 will lose the content
     * of the database after the last connection is closed. With -1  h2 will keep the data until the process exits
     * This connection will create a table called test
     */

//    private static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;"; // --> runs in memory
    private static final String JDBC_URL = "jdbc:h2:~/test";// persistent memory, will be stored in test folder
    // the same URL used to access console
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String CREATE_TABLE_SQL = "CREATE TABLE Customer(" +
            "id bigint auto_increment PRIMARY KEY," +
            "firstname varchar(20),"+
            "lastname varchar(256),"+
            "email varchar (265),"+
            "UNIQUE(email))"; // uniqueness constraint on the email
    private static final String INSERT_SQL_CUSTOMER = "INSERT INTO Customer"+
            "(firstname, lastname, email) VALUES (?,?,?)";
    private static final String SELECT_ALL_SQL = "SELECT * from Customer";
    private static final String SELECT_BY_EMAIL_SQL =
            // select everything from Customer table where email equals an email parameter
            "SELECT * from Customer WHERE email=?";

    public void create(Customer customer) throws SQLException{
        try (Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement(INSERT_SQL_CUSTOMER);
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.executeUpdate();
        }
    }
    public List<Customer> getAll() throws SQLException{
        try (Connection connection = getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL);
            List <Customer> customers = new ArrayList<>();
            while (resultSet.next()){
           customers.add(toCustomer(resultSet));
            }
            return customers;
        }
    }

    public Customer getByEmail (String email) throws SQLException {
        try(Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_EMAIL_SQL);
            // to retrieve results based on a parameter:
            // add email to the first parameter index:
            preparedStatement.setString(1, email);
            // retrieve resultSet from preparedStatement execute query
            ResultSet resultSet = preparedStatement.executeQuery();
            // we know we'll get a single result due to the uniqueness constraint added when creating table,
            // so we can safely call next
            resultSet.next();
            return toCustomer(resultSet);
        }
    }

    public void createTable() throws SQLException {
        // JDBC is the simplest way to interact with any relational database management system (inc.H2) via SQL

        // get a connection via driver manager:
//        Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD); --> catch exception:
        try (Connection connection = getConnection()) {
            // creation of statement that will be used by h2 when we'll send create table request
            Statement statement = connection.createStatement();
            statement.executeUpdate(CREATE_TABLE_SQL);
        }
    }

    private Customer toCustomer(ResultSet resultSet) throws SQLException {
        String firstName = resultSet.getString("firstname");
        String lastName = resultSet.getString("lastname");
        String email = resultSet.getString("email");
        return new Customer(firstName,lastName,email);
    }
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}