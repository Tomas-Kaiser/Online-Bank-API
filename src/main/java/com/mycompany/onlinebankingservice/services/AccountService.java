/*
 * Copyright 2020, Tomas.
 */
package com.mycompany.onlinebankingservice.services;

import com.mycompany.onlinebankingservice.databases.Database;
import com.mycompany.onlinebankingservice.models.Account;
import com.mycompany.onlinebankingservice.models.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Tomas
 */
public class AccountService {

    private Database db = new Database();

    private List<Customer> customers = db.getAllCustomers();
    //private List<Account> accounts = db.getAllAccountDB();

    // return all accounts related to the customer
    public List<Account> getAllAccounts(int accountNum, int password) {
        for (Customer c : customers) {
            boolean accountMatch = false;
            for (Account a : c.getAccounts()) {
                if (a.getAccountNumber() == accountNum) {
                    accountMatch = true;
                }
            }

            if ((accountMatch) && c.getSecurityCredential() == password) {
                return c.getAccounts();
            }
        }

        return null;
    }

    // Create a new account
    public Account getCreateAccount(int accountNum, int password, Account acc) {
        for (Customer c : customers) {
            boolean accountMatch = false;
            for (Account a : c.getAccounts()) {
                if (a.getAccountNumber() == accountNum) {
                    accountMatch = true;
                }
            }

            if ((accountMatch) && c.getSecurityCredential() == password) {
                acc.setId(c.getAccounts().size() + 1);
                System.out.println("set Id: " + (c.getAccounts().size() - 1));
                
                Random randomNum = new Random();
                
                int accNum = randomNum.nextInt((99999999 - 10000000)+1) + 10000000;
                System.out.println("New account number: " + accNum);
                acc.setAccountNumber(accNum);
                
                acc.setTransactions(null);

                c.getAccounts().add(acc);

                return acc;
            }         
        }
        return null;
    }
}
