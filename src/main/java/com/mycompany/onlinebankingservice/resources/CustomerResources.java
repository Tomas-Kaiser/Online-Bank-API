/*
 * Copyright 2020, Tomas.
 */

package com.mycompany.onlinebankingservice.resources;

import com.mycompany.onlinebankingservice.models.Customer;
import com.mycompany.onlinebankingservice.services.CustomerService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Tomas
 */

@Path("/customers")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class CustomerResources {

    CustomerService customerService = new CustomerService();
    
    @GET
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}
