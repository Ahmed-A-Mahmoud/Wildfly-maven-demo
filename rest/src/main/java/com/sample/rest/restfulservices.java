package com.sample.rest;

import com.sample.ejb.PropertyManager;
import com.sample.model.Property;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/properties")
@RequestScoped
public class restfulservices {

    @EJB
    private PropertyManager propertyManager;

    @POST
    @Path("addProperty")
    @Consumes("application/json")
    public Response addProperty(Property property) {
        return propertyManager.addProperty(property)? Response.ok(true).build() : Response.ok(false).build();
    }

    @GET
    @Path("getProperty")
    @Produces("application/json")
    public Response getProperty() {
        return Response.ok(propertyManager.getProperty()).build();
    }

//    @DELETE
//    @Path("deleteMovie/{movieName}")
//    @Produces("application/json")
//    public Response deleteMoviebyname(@PathParam("movieName") String movieName) {
//        return Response.ok(cleanService.deleteMoviebyname(movieName)).build();
//    }
}
