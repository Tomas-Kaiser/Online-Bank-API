/*
 * Copyright 2020, Tomas.
 */

package com.mycompany.onlinebankingservice.resources;

import com.mycompany.onlinebankingservice.models.Customer;
import com.mycompany.onlinebankingservice.services.CustomerService;
import java.util.List;
import javax.ws.rs.DELETE;
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
    
    @DELETE
    @Path("/{email}/{password}")
    public String getRemoveCustomer(@PathParam("email") String email, @PathParam("password") int password){
        return customerService.getRemoveCustomer(email, password);
    }
        
    @GET
    @Path("/{email}/{password}")
    public Customer getCustomer(@PathParam("email") String email, @PathParam("password") int password){
       if (email != null &&  password != 0){
            return customerService.getCustomer(email, password);
       }
       return null;       
    }
    
    // TODO: validation! Check if the received data are valid.
    @POST
    public Customer createCustomer(Customer c){
        return customerService.getCreateCustomer(c);
    }
    
    @Path("/{email}/{password}/accounts")
    public AccountResource getAccountResource(){
        return new AccountResource();
    }
}
