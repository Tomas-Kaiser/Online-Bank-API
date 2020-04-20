package com.mycompany.onlinebankingservice.services;

import com.mycompany.onlinebankingservice.databases.Database;
import com.mycompany.onlinebankingservice.models.Account;
import com.mycompany.onlinebankingservice.models.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerService {

    private Database db = new Database();

    private List<Customer> customers = db.getAllCustomersDB();

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerById(int id) {
        return customers.get(id - 1);
    }

    public Customer getCustomer(String email, int password) {
        return selectCustomer(email, password);
    }

    public Customer getCreateCustomer(Customer c) {
        c.setId(customers.size() + 1);
        customers.add(c);

        List<Account> emptyList = new ArrayList();
        c.setAccounts(emptyList);

        return c;
    }

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

    private Customer selectCustomer(String email, int password) {
        for (Customer c : customers) {
            if ((c.getEmail().equalsIgnoreCase(email)) && c.getSecurityCredential() == password) {
                return c;
            }
        }
        return null;
    }
}
