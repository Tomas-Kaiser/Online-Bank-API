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

    // return the account related to the customer
    public Account getAccount(int accountNum, int password) {
        return selectAccount(accountNum, password);
    }

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
                acc.setAccountNumber(createAccountNumber());
                acc.setTransactions(null); // TODO: Has this have any effect?
                
                c.getAccounts().add(acc);

                return acc;
            }
        }
        return null;
    }

    private Account selectAccount(int accountNum, int password) {
        for (Customer c : customers) {
            Account currentAccount = new Account();
            boolean accountMatch = false;
            for (Account a : c.getAccounts()) {
                if (a.getAccountNumber() == accountNum) {
                    currentAccount = a;
                    accountMatch = true;
                }
            }

            if ((accountMatch) && c.getSecurityCredential() == password) {
                return accountMatch ? currentAccount : null;
            }
        }
        return null;
    }
    
    private int createAccountNumber(){
        Random randomNum = new Random();
        return randomNum.nextInt((99999999 - 10000000) + 1) + 10000000;
    }
}
