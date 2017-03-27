/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcsreddy.restmessenger.resources;

import com.gcsreddy.restmessenger.exception.DataNotFoundException;
import com.gcsreddy.restmessenger.model.ErrorMessage;
import com.gcsreddy.restmessenger.model.Link;
import com.gcsreddy.restmessenger.model.Message;
import com.gcsreddy.restmessenger.service.MessageService;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author gcsreddy
 */
@Path("/messages")
public class MessageResource {
  
  MessageService messageService = new MessageService();
  
  @GET
  //@Produces(MediaType.APPLICATION_JSON)
  @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  //produces both in json and text format
  public List<Message> getMessages(@QueryParam("year") int year){
    List<Message> messages;
    System.out.println("year = "+year);
    if(year > 0){
      messages = messageService.getAllMessagesForYear(year);
    }else{
      messages = messageService.getAllMessages();
    }
    return messages;
  }
  
  @GET
  @Produces(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
  @Path("/{messageId}")
  //path {string} should match pathparam's name
  //and it is auto casted to arugment next to it
  //you can have multiple pathparams and arguments
  //can use regex too
  public Message getMessage(@PathParam("messageId") long id,
          @Context UriInfo uriinfo){
    Message msg = messageService.getMessage(id);
    if(msg == null){
      
      ErrorMessage err = new ErrorMessage(
            "data not found", 404, "www.google.com");
      Response response = Response.status(Response.Status.NOT_FOUND)
            .entity(err)
            .build();
      throw new WebApplicationException(response);
    }
    
    String selfuri = uriinfo.getBaseUriBuilder()
            .path(MessageResource.class)
            .path(Long.toString(msg.getId()))
            .build()
            .toString();
    String profileuri = uriinfo.getBaseUriBuilder()
            .path(ProfileResource.class)
            .path(msg.getAuthor())
            .build()
            .toString();
//    String commentsuri = uriinfo.getBaseUriBuilder()
//            .path(MessageResource.class)
//            .path(MessageResource.class, "getCommentResource")
//             //getCommentResource method has has {methodId} in the path :(
//            //resolve {methodId} in the URI
//            .resolveTemplate("methodId", Long.toString(msg.getId()))
//            .build()
//            .toString();
    
    msg.getLinks().add( new Link(selfuri,"self"));
    msg.getLinks().add( new Link(profileuri,"profile"));
//    msg.getLinks().add( new Link(commentsuri,"comments"));
    return msg;
  }
  
//  @POST
//  @Produces(MediaType.APPLICATION_JSON)
//  @Consumes(MediaType.APPLICATION_JSON)
//  public Message addMessage(Message message){
//    
//    return messageService.addMessage(message);
//    
//  }
  
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response addMessage(Message message, @Context UriInfo uriinfo){
    Message msg = messageService.addMessage(message);
//    return Response.status(Response.Status.CREATED)
//            .entity(msg)
//            .build();

//send the uri for the new message resource added
    URI uri = uriinfo
            .getAbsolutePathBuilder()
            .path(String.valueOf(msg.getId()))
            .build();
    return Response.created(uri)
            .entity(msg)
            .build();
    
  }
  
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/{messageId}")
  public Message updateMessage(@PathParam("messageId") long id, 
          Message message){
    message.setId(id);
    messageService.updateMessage(message);
    return message;
  }
  
  @DELETE
  @Path("/{delMessageId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Message deleteMessage(@PathParam("delMessageId") long id){
    return messageService.removeMessage(id);
  }
  
  //Sub resource example
  
  @Path("/{messageId}/comments")
  public CommentResource getCommentResource(){
    return new CommentResource();
  }
  
  
  
  
}

//annotations on methods override class annotations.
//different combinations of annotations can be used to
//direct a request to different methods to be handled.