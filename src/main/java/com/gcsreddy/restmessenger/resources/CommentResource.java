/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcsreddy.restmessenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author gcsreddy
 */
@Path("/")
public class CommentResource {//sub resource
  
  
  @GET
  public String test(){
    //http://localhost:8080/restmessenger/messages/1/comments
    return "sub resource";
  }
  
  @GET
  @Path("{commentId}")
  public String getCommentId(@PathParam("commentId") long commentid,
          @PathParam("messageId") long messageid){
    //http://localhost:8080/restmessenger/messages/1/comments
    
    return "commentid = "+commentid+ " for message id = "+ messageid;
  }
}
