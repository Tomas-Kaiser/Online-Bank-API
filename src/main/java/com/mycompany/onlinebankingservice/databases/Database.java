/*
 * Copyright 2020, Tomas.
 */

package com.mycompany.onlinebankingservice.databases;

import com.mycompany.onlinebankingservice.models.Account;
import com.mycompany.onlinebankingservice.models.Customer;
import com.mycompany.onlinebankingservice.models.Transaction;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Tomas
 */

public class Database {
    public static List<Transaction> transactionsDB = new ArrayList<>();
    public static List<Account> accountDB = new ArrayList<>();
    public static List<Customer> customersDB = new ArrayList<>();  
    public static boolean init = false;
    
    public Database(){
        if(!init){
            Transaction t1 = new Transaction(1, true, false, new Date(), "This is a transaction 1");
            Transaction t2 = new Transaction(2, true, false, new Date(), "This is a transaction 2");
            transactionsDB.add(t1);
            transactionsDB.add(t2);
            
            Account acc1 = new Account(1, 112233, 11112222, 8_000, true, false, transactionsDB);  
            accountDB.add(acc1);
            
            Customer c1 = new Customer(1, "Byrnes Lane, Dublin 2", "tom@gmail.com", 1234, accountDB); 
            customersDB.add(c1);         
            
            init = true;
        }
    }
    
    public List<Customer> getAllCustomers(){
        return customersDB;
    }
    
}
