/*
 * Copyright 2020, Tomas.
 */

package com.mycompany.onlinebankingservice.services;

import com.mycompany.onlinebankingservice.databases.Database;
import com.mycompany.onlinebankingservice.models.Customer;
import java.util.List;

/**
 * @author Tomas
 */

public class CustomerService {
    Database db = new Database();
    
    List<Customer> customers = db.getAllCustomers(); 
    
    public List<Customer> getAllCustomers(){       
        return customers;
    }
}
