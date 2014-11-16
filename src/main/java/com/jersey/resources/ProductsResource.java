package com.jersey.resources;

import com.jersey.representations.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductsResource {

    @GET
    public List<Product> getAll(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "iPhone 6", "USD", 850D, 750D));
        return products;
    }

    @GET
    @Path("{id}")
    public Product getOne(@PathParam("id")Long id){
        if(id == 888){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            return new Product(id, "iPhone 6", "USD", 850D, 750D);
        }
    }
}