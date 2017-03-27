/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcsreddy.restmessenger.rest.client;

import com.gcsreddy.restmessenger.model.Message;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author gcsreddy
 */
public class RestApiClient {
  public static void main(String[] args){
    
    Client client = ClientBuilder.newClient();
    Response get = client
            .target("http://localhost:8080/restmessenger/messages/1")
            .request().accept(MediaType.TEXT_PLAIN)
            .get();
    
    System.out.println("response = "+ 
            get.readEntity(String.class));
  }
}
