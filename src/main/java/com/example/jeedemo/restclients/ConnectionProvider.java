package com.example.jeedemo.restclients;

import java.io.IOException;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

public class ConnectionProvider {

  String baseURL = "";

  @Produces
  @Connection
  public WebTarget producex() {
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(baseURL);
    target.register(RequestFilter.class);
    target.register(ResponseFilter.class);
    return target;
  }

  public static class RequestFilter implements ClientRequestFilter {

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
      requestContext.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
      System.out.println("request filter completed");
    }
  }

  public static class ResponseFilter implements ClientResponseFilter {

    @Override
    public void filter(
        ClientRequestContext clientRequestContext, ClientResponseContext clientResponseContext)
        throws IOException {
      int status = clientResponseContext.getStatus();
      if (!(status / 100 == 2)) {
        throw new RuntimeException("unsucessful requeset response");
      }
    }
  }
}
