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
public class Customer {
    private int id;
    private String Address;
    private String email;
    private int securityCredential;
    private List<Account> accounts;
    
    public Customer(){}

    public Customer(int id, String Address, String email, int securityCredential, List<Account> accounts) {
        this.id = id;
        this.Address = Address;
        this.email = email;
        this.securityCredential = securityCredential;
        this.accounts = accounts;
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
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the securityCredential
     */
    public int getSecurityCredential() {
        return securityCredential;
    }

    /**
     * @param securityCredential the securityCredential to set
     */
    public void setSecurityCredential(int securityCredential) {
        this.securityCredential = securityCredential;
    }

    /**
     * @return the accounts
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * @param accounts the accounts to set
     */
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    
    
}
