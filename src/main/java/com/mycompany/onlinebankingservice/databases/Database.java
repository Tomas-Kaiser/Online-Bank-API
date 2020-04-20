package com.mycompany.onlinebankingservice.databases;

import com.mycompany.onlinebankingservice.models.Account;
import com.mycompany.onlinebankingservice.models.Customer;
import com.mycompany.onlinebankingservice.models.Transaction;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {
    private static List<Transaction> transactionsDB = new ArrayList<>();
    private static List<Account> accountsDB = new ArrayList<>();
    public static List<Customer> customersDB = new ArrayList<>();
    public static boolean init = false;

    // Initialize database with one cusotmer which has one account along with two transactions
    public Database() {
        if (!init) {
            Transaction t1 = new Transaction(1, true, false, new Date(), "This is a transaction 1");
            Transaction t2 = new Transaction(2, true, false, new Date(), "This is a transaction 2");
            transactionsDB.add(t1);
            transactionsDB.add(t2);

            Account acc1 = new Account(1, 112233, 11112222, 8_000, true, false, getAllTransactionsDB());
            accountsDB.add(acc1);

            Customer c1 = new Customer(1, "Pearse Street, Dublin 2", "tom@gmail.com", 1234, getAllAccountsDB());
            customersDB.add(c1);

            init = true;
        }
    }
    
    /**
     * @return the customersDB
     */
    public List<Customer> getAllCustomersDB() {
        return customersDB;
    }

    /**
     * @return the transactionsDB
     */
    public List<Transaction> getAllTransactionsDB() {
        return transactionsDB;
    }

    /**
     * @return the accountDB
     */
    public List<Account> getAllAccountsDB() {
        return accountsDB;
    }

}
