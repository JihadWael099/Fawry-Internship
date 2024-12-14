package com.excample.jakarta.hello;

import jakarta.faces.render.ResponseStateManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/products")
public class ProductResource
{
    ProductMannager productMannager=new ProductMannager();


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/AddProduct/{name}/{price}")
    public Response AddProduct(@PathParam("name") String name,@PathParam("price") double price){
        try {
            productMannager.AddProduct(new Product(name,price, productMannager.GetAllProducts().size()+1));
            return Response.status(Response.Status.CREATED).entity(new Product(name,price, productMannager.GetAllProducts().size()+1)).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetAllproducts(){

        return  Response.ok(productMannager.GetAllProducts()).build();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductByname(@PathParam("name") String name){
       return Response.ok(productMannager.GetProductByName(name)).build();
    }

    @DELETE
    @Path("/Delet/{name}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response DeleteProduct(@PathParam("name") String name){
      try {
          productMannager.DeleteProduct(name);
          return Response.status(Response.Status.NO_CONTENT).build();

      }
      catch (RuntimeException e){
          return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
      }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/Update/{oldName}/{NewName}/{NewPrice}")
    public Response UpdateProduct(@PathParam("oldName") String oldName,@PathParam("NewName") String NewName,@PathParam("NewPrice") double NewPrice){
        try {
            productMannager.updateProduct(oldName,NewName,NewPrice);
            return Response.status(Response.Status.CREATED).entity(productMannager.GetProductByName(NewName)).build();
        }
        catch (RuntimeException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }


    }


}
