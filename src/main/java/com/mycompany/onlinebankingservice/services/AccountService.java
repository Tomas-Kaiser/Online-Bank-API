package com.mycompany.onlinebankingservice.services;

import com.mycompany.onlinebankingservice.databases.Database;
import com.mycompany.onlinebankingservice.models.Account;
import com.mycompany.onlinebankingservice.models.Customer;
import com.mycompany.onlinebankingservice.models.Transaction;
import com.mycompany.onlinebankingservice.resources.TransactionResource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class AccountService {

    // Initialize database
    private Database db = new Database();

    // Store all customers in a list
    private List<Customer> customers = db.getAllCustomersDB();

    // Initialize transactionService
    private TransactionService transactionService = new TransactionService();

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

    // Remove a particular account
    public String getRemoveAccount(String email, int password, int accNum) {
        for (Customer c : customers) {
            if (c.getEmail().equalsIgnoreCase(email) && c.getSecurityCredential() == password) {

                int pos = 0;

                for (Account a : c.getAccounts()) {
                    if (a.getAccountNumber() == accNum) {
                        c.getAccounts().remove(pos);
                        break;
                    }
                    pos++;
                }

                System.out.println("Account removed!!!!");
                return "Account removed!";
            }
        }
        return "Account did not found";
    }

    // Create an account
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

    // Return a balance for a particular account
    public Double getBalance(String email, int password, int accNum) {
        Account acc = selectAccount(email, password, accNum);

        // Creata log in transaction that the user checked their account
        Transaction tran = new Transaction();
        tran.setCreated(new Date());
        tran.setDescription("You asked for current balance. Current balance is: " + acc.getCurrentBalance());
        tran.setId(acc.getTransactions().size() + 1);
        
        transactionService.getCreateTransaction(email, password, accNum, tran);

        return acc.getCurrentBalance();
    }

    // Return amount of withdrawal and create transaction
    public Double getWithdrawal(String email, int password, int accNum, double amount) {
        Account acc = selectAccount(email, password, accNum);
        double newBalance = acc.getCurrentBalance() - amount;
        acc.setCurrentBalance(newBalance);

        Transaction tran = new Transaction();

        tran.setCreated(new Date());
        tran.setDescription("Withdrawal " + amount + " - remaining balance is " + newBalance);
        tran.setId(acc.getTransactions().size() + 1);

        transactionService.getCreateTransaction(email, password, accNum, tran);

        return newBalance;
    }

    // Return amount of lodgement and create a transaction
    public Double getLodgement(String email, int password, int accNum, double amount) {
        Account acc = selectAccount(email, password, accNum);
        double newBalance = acc.getCurrentBalance() + amount;
        acc.setCurrentBalance(newBalance);

        Transaction tran = new Transaction();

        tran.setCreated(new Date());
        tran.setDescription("Lodgement " + amount + " - remaining balance is " + newBalance);
        tran.setId(acc.getTransactions().size() + 1);

        transactionService.getCreateTransaction(email, password, accNum, tran);

        return newBalance;
    }

    // Create a transfer between two accounts and create a transaction
    public Double getTransfer(String email, int password, int accNum, int accNumReceiver, double amount) {
        // Sender
        Account accSender = selectAccount(email, password, accNum);
        double newBalance = accSender.getCurrentBalance() - amount;
        accSender.setCurrentBalance(newBalance);

        Transaction tranSend = new Transaction();

        tranSend.setCreated(new Date());
        tranSend.setDescription("Transfer: sending " + amount + " to " + accNumReceiver + " - remaining balance is " + newBalance);
        tranSend.setId(accSender.getTransactions().size() + 1);

        transactionService.getCreateTransaction(email, password, accNum, tranSend);

        // Receiver
        Account accReceiver = new Account();
        Customer customerReceiver = new Customer();
        for (Customer c : customers) {
            for (Account a : c.getAccounts()) {
                if (a.getAccountNumber() == accNumReceiver) {
                    accReceiver = a;
                    customerReceiver = c;
                }
            }
        }

        newBalance = accReceiver.getCurrentBalance() + amount;
        accReceiver.setCurrentBalance(newBalance);

        Transaction tranReceiver = new Transaction();

        tranReceiver.setCreated(new Date());
        tranReceiver.setDescription("Transfer: receiving " + amount + " from " + accNum + " - remaining balance is " + newBalance);
        tranReceiver.setId(accSender.getTransactions().size() + 1);

        transactionService.getCreateTransaction(customerReceiver.getEmail(), customerReceiver.getSecurityCredential(), accNumReceiver, tranReceiver);

        return newBalance;
    }

    // Selecting an account
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

    // Creating a random number
    private int createAccountNumber() {
        Random randomNum = new Random();
        return randomNum.nextInt((99999999 - 10000000) + 1) + 10000000;
    }
}
