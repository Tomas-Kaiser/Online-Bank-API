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

    private Database db = new Database();

    private List<Customer> customers = db.getAllCustomers();

    public List<Transaction> getAllTransaction(String email, int password, int accNum) {
        // Select the customer
        for (Customer c : customers) {
            boolean accountMatch = false;
            Account currentAccount = new Account();
            for (Account a : c.getAccounts()) {
                if (a.getAccountNumber() == accNum) {
                    currentAccount = a;
                    accountMatch = true;
                }
            }

            // If customer exists, select the transaction related to the account number
            if ((accountMatch) && c.getSecurityCredential() == password && c.getEmail().equalsIgnoreCase(email)) {
                return accountMatch ? currentAccount.getTransactions() : null;
            }
        }
        return null;
    }

    public Transaction getCreateTransaction(String email, int password, int accNum, Transaction tran) {
        // Select the customer
        for (Customer c : customers) {
            boolean accountMatch = false;
            Account currentAccount = new Account();
            for (Account a : c.getAccounts()) {
                if (a.getAccountNumber() == accNum) {
                    currentAccount = a;
                    accountMatch = true;
                }
            }

            // If customer exists, select the transaction related to the account number
            if ((accountMatch) && c.getSecurityCredential() == password && c.getEmail().equalsIgnoreCase(email)) {
                tran.setId(currentAccount.getTransactions().size() + 1);
                tran.setCreated(new Date());
                currentAccount.getTransactions().add(tran);
                
                return tran;
            }
        }

        return null;
    }
}
