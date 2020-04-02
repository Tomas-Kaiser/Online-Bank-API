/*
 * Copyright 2020, Tomas.
 */
package com.mycompany.onlinebankingservice.services;

import com.mycompany.onlinebankingservice.databases.Database;
import com.mycompany.onlinebankingservice.models.Account;
import com.mycompany.onlinebankingservice.models.Customer;
import com.mycompany.onlinebankingservice.models.Transaction;
import java.util.Date;
import java.util.List;

/**
 * @author Tomas
 */
public class TransactionService {

    Database db = new Database();

    private List<Customer> customers = db.getAllCustomers();

    public List<Transaction> getAllTransaction(int accountNum, int password) {
        // Select the customer
        for (Customer c : customers) {
            boolean accountMatch = false;
            for (Account a : c.getAccounts()) {
                if (a.getAccountNumber() == accountNum) {
                    accountMatch = true;
                }
            }

            // If customer exists, select the transaction related to the account number
            if ((accountMatch) && c.getSecurityCredential() == password) {
                for (Account a : c.getAccounts()) {
                    if (a.getAccountNumber() == accountNum) {
                        return a.getTransactions();
                    }
                }
            }
        }
        return null;
    }

    public Transaction getCreateTransaction(int accountNum, int password, Transaction tran) {
        // Select the customer
        for (Customer c : customers) {
            boolean accountMatch = false;
            for (Account a : c.getAccounts()) {
                if (a.getAccountNumber() == accountNum) {
                    accountMatch = true;
                }
            }

            // If customer exists, select the transaction related to the account number
            if ((accountMatch) && c.getSecurityCredential() == password) {
                for (Account a : c.getAccounts()) {
                    if (a.getAccountNumber() == accountNum) {
                        tran.setId(a.getTransactions().size() + 1);
                        tran.setCreated(new Date());
                        
                        a.getTransactions().add(tran);
                        return tran;
                    }
                }
            }
        }

        return null;
    }
}
