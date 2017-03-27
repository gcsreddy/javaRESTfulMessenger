/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcsreddy.restmessenger.exception;

import com.gcsreddy.restmessenger.model.ErrorMessage;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author gcsreddy
 */
@Provider //registers in jax rs. it know there is an exception mapper
public class DataNotFoundExceptionMapper implements 
        ExceptionMapper<DataNotFoundException>{

  @Override
  public Response toResponse(DataNotFoundException e) {
    ErrorMessage err = new ErrorMessage(
            "data not found", 404, "www.google.com");
    return Response.status(Response.Status.NOT_FOUND)
            .entity(err)
            .build();
  }
  
}
