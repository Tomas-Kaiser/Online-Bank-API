/*
 * Copyright 2020, Tomas.
 */

package com.mycompany.onlinebankingservice.models;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tomas
 */
@XmlRootElement
public class Account {
    private int id;
    private int sortCode;
    private int accountNumber;
    private double currentBalance;
    private boolean currentAcc;
    private boolean savingAcc;
    private List<Transaction> transactions;

    public Account(){}

    public Account(int id, int sortCode, int accountNumber, double currentBalance, boolean currentAcc, boolean savingAcc, List<Transaction> transactions) {
        this.id = id;
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.currentAcc = currentAcc;
        this.savingAcc = savingAcc;
        this.transactions = transactions;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the sortCode
     */
    public int getSortCode() {
        return sortCode;
    }

    /**
     * @param sortCode the sortCode to set
     */
    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    /**
     * @return the accountNumber
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the currentBalance
     */
    public double getCurrentBalance() {
        return currentBalance;
    }

    /**
     * @param currentBalance the currentBalance to set
     */
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    /**
     * @return the currentAcc
     */
    public boolean isCurrentAcc() {
        return currentAcc;
    }

    /**
     * @param currentAcc the currentAcc to set
     */
    public void setCurrentAcc(boolean currentAcc) {
        this.currentAcc = currentAcc;
    }

    /**
     * @return the savingAcc
     */
    public boolean isSavingAcc() {
        return savingAcc;
    }

    /**
     * @param savingAcc the savingAcc to set
     */
    public void setSavingAcc(boolean savingAcc) {
        this.savingAcc = savingAcc;
    }

    /**
     * @return the transactions
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * @param transactions the transactions to set
     */
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    

    
    
}
