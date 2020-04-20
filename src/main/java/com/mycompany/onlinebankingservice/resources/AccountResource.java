package com.mycompany.onlinebankingservice.resources;

import com.mycompany.onlinebankingservice.models.Account;
import com.mycompany.onlinebankingservice.services.AccountService;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {
    
    // Initialize accountService object
    private AccountService accountService = new AccountService();
    
    // Return a list of all open bank accounts for a particular customer based on their email and password
    @GET
    public List<Account> getAllAccounts(@PathParam("email") String email, @PathParam("password") int password) {
        return accountService.getAllAccounts(email, password);
    }
    
    // Craete a new bank account for a particular customer based on email, password and passing JSON object acc
    @POST
    public Account getCreateAccount(@PathParam("email") String email, @PathParam("password") int password, Account acc) {
        return accountService.getCreateAccount(email, password, acc);
    }
    
    // Return a particular account
    @GET
    @Path("/{accNum}")
    public Account getAccount(@PathParam("email") String email, @PathParam("password") int password, @PathParam("accNum") int accNum) {
        return accountService.getAccount(email, password, accNum);
    }
    
    // Delete an account for a particular customer based on email, password and account number
    @DELETE
    @Path("/{accNum}")
    @Produces("text/plain")
    public String gerRemoveAccount(@PathParam("email")String email, @PathParam("password") int password, @PathParam("accNum") int accNum){
        return accountService.getRemoveAccount(email, password, accNum);
    }
    
    // Return a current balance for a particular account
    @GET
    @Path("/{accNum}/balance")
    @Produces("text/plain")
    public double getBalance(@PathParam("email") String email, @PathParam("password") int password, @PathParam("accNum") int accNum) {
        return accountService.getBalance(email, password, accNum);
    }
    
    // Withdrawal money from a particular account
    @GET
    @Path("/{accNum}/withdrawal/{amount}")
    @Produces("text/plain")
    public double getWithdrawal(@PathParam("email") String email, @PathParam("password") int password,
            @PathParam("accNum") int accNum, @PathParam("amount") int amount) {
        return accountService.getWithdrawal(email, password, accNum, amount);
    }
    
    // Ledgement money to a particular account
    @GET
    @Path("/{accNum}/lodgement/{amount}")
    @Produces("text/plain")
    public double getLedgement(@PathParam("email") String email, @PathParam("password") int password,
            @PathParam("accNum") int accNum, @PathParam("amount") int amount) {
        return accountService.getLodgement(email, password, accNum, amount);
    }
    
    // Transfer money from a particular account to another account
    @GET
    @Path("/{accNum}/transfer/{accNumReceiver}/{amount}")
    @Produces("text/plain")
    public double getTransfer(@PathParam("email") String email, @PathParam("password") int password,
            @PathParam("accNum") int accNum, @PathParam("accNumReceiver") int accNumReceiver, @PathParam("amount") int amount) {
        return accountService.getTransfer(email, password, accNum, accNumReceiver, amount);
    }

    // Connecting to SubResource (transaction resource)
    @Path("/{accNum}/transactions")
    public TransactionResource getTransactionResource() {
        return new TransactionResource();
    }

}
