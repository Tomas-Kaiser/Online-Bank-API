/*
 * Copyright 2020, Tomas.
 */
package com.mycompany.onlinebankingservice.services;

import com.mycompany.onlinebankingservice.databases.Database;
import com.mycompany.onlinebankingservice.models.Account;
import com.mycompany.onlinebankingservice.models.Customer;
import java.util.List;

/**
 * @author Tomas
 */
public class CustomerService {

    Database db = new Database();

    List<Customer> customers = db.getAllCustomers();

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerById(int id) {
        return customers.get(id - 1);
    }

    public Customer getCustomer(int accountNum, int password) {
        Customer customer = new Customer();
        for (Customer c : customers) {           
            boolean accountMatch = false;
            for (Account a : c.getAccounts()){
                if (a.getAccountNumber() == accountNum)
                    accountMatch = true;
            }
            
            if ((accountMatch) && c.getSecurityCredential() == password)
                return c;

        }
        return null;
    }

    public Customer getCreateCustomer(Customer c) {
        c.setId(customers.size() + 1);

        customers.add(c);

        return c;
    }
}
