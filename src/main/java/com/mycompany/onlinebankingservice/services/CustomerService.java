package com.mycompany.onlinebankingservice.services;

import com.mycompany.onlinebankingservice.databases.Database;
import com.mycompany.onlinebankingservice.models.Account;
import com.mycompany.onlinebankingservice.models.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerService {
    
    // Initialize database
    private Database db = new Database();

    // Store all customers in a list
    private List<Customer> customers = db.getAllCustomersDB();

    // return a list of all customers
    public List<Customer> getAllCustomers() {
        return customers;
    }
    
    // return a customer based on id
    public Customer getCustomerById(int id) {
        return customers.get(id - 1);
    }
    
    // return a particular customer
    public Customer getCustomer(String email, int password) {
        return selectCustomer(email, password);
    }
    
    // Create a new customer and add it to the customers list
    public Customer getCreateCustomer(Customer c) {
        c.setId(customers.size() + 1);
        customers.add(c);

        List<Account> emptyList = new ArrayList();
        c.setAccounts(emptyList);

        return c;
    }
    
    // Remove customer from the list customers
    public String getRemoveCustomer(String email, int password) {
        int pos = 0;
        for (Customer c : customers) {
            if ((c.getEmail().equalsIgnoreCase(email)) && c.getSecurityCredential() == password) {
                customers.remove(pos);
                return "Customer has been deleted!";
            }
            pos++;           
        }
        return "Customer does not exist!";
    }

    // Selecting a particular customer based on email and password
    private Customer selectCustomer(String email, int password) {
        for (Customer c : customers) {
            if ((c.getEmail().equalsIgnoreCase(email)) && c.getSecurityCredential() == password) {
                return c;
            }
        }
        return null;
    }
}
