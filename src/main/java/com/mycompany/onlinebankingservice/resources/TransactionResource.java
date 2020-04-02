/*
 * Copyright 2020, Tomas.
 */

package com.mycompany.onlinebankingservice.resources;

import com.mycompany.onlinebankingservice.models.Transaction;
import com.mycompany.onlinebankingservice.services.TransactionService;
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

@Path("/transactions")
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {
    
    private TransactionService transactionService = new TransactionService();
    
    // Get all transaction related to the customer and type of account
    @GET
    public List<Transaction> getAllTransaction(@PathParam("accountNum") int accountNum, @PathParam("password") int password){
        return transactionService.getAllTransaction(accountNum, password);
    }
    
    @POST
    public Transaction getCreateTransaction(@PathParam("accountNum") int accountNum, @PathParam("password") int password, Transaction tran){
        return transactionService.getCreateTransaction(accountNum, password, tran);
    }
}
