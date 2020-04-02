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
    public List<Account> getAllAccounts(@PathParam("email") String email, @PathParam("password") int password){
        return accountService.getAllAccounts(email, password);
    }
    
    @POST
    public Account getCreateAccount(@PathParam("email") String email, @PathParam("password") int password, Account acc) {
        return accountService.getCreateAccount(email, password, acc);
    }

    @GET
    @Path("/{accNum}")
    public Account getAccount(@PathParam("email") String email, @PathParam("password") int password, @PathParam("accNum") int accNum) {
        return accountService.getAccount(email, password, accNum);
    }

    @Path("/{accNum}/transactions")
    public TransactionResource getTransactionResource() {
        return new TransactionResource();
    }

}
