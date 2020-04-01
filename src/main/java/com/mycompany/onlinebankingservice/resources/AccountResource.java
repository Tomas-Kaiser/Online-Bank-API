/*
 * Copyright 2020, Tomas.
 */

package com.mycompany.onlinebankingservice.resources;

import com.mycompany.onlinebankingservice.models.Account;
import com.mycompany.onlinebankingservice.services.AccountService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Tomas
 */

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {
    
    private AccountService accountService = new AccountService();
    
    @GET
    public List<Account> getAllAccounts(@PathParam("accountNum") int accountNum, @PathParam("password") int password){
        return accountService.getAllAccounts(accountNum, password);
    }
    
    @POST
    public Account getCreateAccount(@PathParam("accountNum") int accountNum, @PathParam("password") int password, Account acc){
        return accountService.getCreateAccount(accountNum, password, acc);
    }
    
    @Path("/transactions")
    public TransactionResource getTransactionResource(){
        return new TransactionResource();
    }
    
    
    
}
