package com.example.jeedemo.jmsdemo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("messages")
public class JmsDemoResource {

    @Inject
    private MessageDeliveryService service;

    @GET
    @Path("{name}")
    public void handleEvent(@PathParam("name") final String name) {
    System.out.println("i am here");
        service.handleEvent(name);
    }
}
