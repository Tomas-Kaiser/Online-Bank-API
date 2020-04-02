/*
 * Copyright 2020, Tomas.
 */
package com.mycompany.onlinebankingservice.services;

import com.mycompany.onlinebankingservice.databases.Database;
import com.mycompany.onlinebankingservice.models.Account;
import com.mycompany.onlinebankingservice.models.Customer;
import com.mycompany.onlinebankingservice.models.Transaction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Tomas
 */
public class AccountService {

    private Database db = new Database();

    private List<Customer> customers = db.getAllCustomers();
    //private List<Account> accounts = db.getAllAccountDB();

    public List<Account> getAllAccounts(String email, int password) {
        for (Customer c : customers) {
            if ((c.getEmail().equalsIgnoreCase(email)) && c.getSecurityCredential() == password) {
                return c.getAccounts();
            }
        }
   
        return null;
    }

    // return the account related to the customer
    public Account getAccount(String email, int password, int accNum) {
        return selectAccount(email, password, accNum);
    }

    public Account getCreateAccount(String email, int password, Account acc) {
        for (Customer c : customers) {
            if (c.getEmail().equalsIgnoreCase(email) && c.getSecurityCredential() == password) {
                acc.setId(c.getAccounts().size() + 1);
                acc.setAccountNumber(createAccountNumber());
                
                List<Transaction> emptyList = new ArrayList();
                acc.setTransactions(emptyList);
                
                c.getAccounts().add(acc);

                return acc;
            }
        }
        return null;
    }

    private Account selectAccount(String email, int password, int accNum) {
        for (Customer c : customers) {
            Account currentAccount = new Account();
            boolean accountMatch = false;
            for (Account a : c.getAccounts()) {
                if (a.getAccountNumber() == accNum) {
                    currentAccount = a;
                    accountMatch = true;
                }
            }

            if ((accountMatch) && c.getSecurityCredential() == password && c.getEmail().equalsIgnoreCase(email)) {
                return accountMatch ? currentAccount : null;
            }
        }
        return null;
    }

    private int createAccountNumber() {
        Random randomNum = new Random();
        return randomNum.nextInt((99999999 - 10000000) + 1) + 10000000;
    }
}
