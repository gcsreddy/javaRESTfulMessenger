/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcsreddy.restmessenger.rest;

import java.util.Calendar;
import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author gcsreddy
 */

public class DateResource {
  
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("date/{dateStr}")
  public String getReqestedDate(@PathParam("dateStr") MyDate mydate){
    
    return "Got my date "+ mydate.toString();
  }
  
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("getdate")
  public Date getTodaysDate(){
    
    return Calendar.getInstance().getTime();
  }
}
