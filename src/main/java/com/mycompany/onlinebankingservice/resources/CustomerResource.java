/*
 * Copyright 2020, Tomas.
 */

package com.mycompany.onlinebankingservice.resources;

import com.mycompany.onlinebankingservice.models.Customer;
import com.mycompany.onlinebankingservice.services.CustomerService;
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

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private CustomerService customerService = new CustomerService();
    
    @GET
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    
    /*
    @GET
    @Path("/{customerId}")
    public Customer getCustomerById(@PathParam("customerId") int id){
        return customerService.getCustomerById(id);
    }
    */
    
    @GET
    @Path("/{accountNum}/{password}")
    public Customer getCustomer(@PathParam("accountNum") int accountNum, @PathParam("password") int password){
        return customerService.getCustomer(accountNum, password);
    }
    
    @POST
    public Customer createCustomer(Customer c){
        return customerService.getCreateCustomer(c);
    }
    
    @Path("/{accountNum}/{password}/accounts")
    public AccountResource getAccountResource(){
        return new AccountResource();
    }
}
