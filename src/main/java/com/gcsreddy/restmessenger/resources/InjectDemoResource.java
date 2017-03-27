/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcsreddy.restmessenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author gcsreddy
 */
@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
  
  @GET
  @Path("annotations")
  public String getParamsUsingAnnotaitons(
          @MatrixParam("matparam") String matrixparam,
          @HeaderParam("customheader") String custHeaderVal,
          @CookieParam("cname") String coockie){
    //url = http://localhost:8080/restmessenger/injectdemo/annotations;matparam=matvalue
    return "from annotations Matrix param's value = "+matrixparam+
            "custom header value = "+custHeaderVal;
  }
  
  @GET
  @Path("context")
  public String getParamsUsingContext(@Context UriInfo uriinfo,
          @Context HttpHeaders hhtpheaders){
    //uriinfo has all kinds of params
    http://localhost:8080/restmessenger/injectdemo/context
    return "Params using context "+uriinfo.getAbsolutePath();
  }
}
