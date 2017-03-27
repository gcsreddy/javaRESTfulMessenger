/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcsreddy.restmessenger.resources;

import com.gcsreddy.restmessenger.model.Profile;
import com.gcsreddy.restmessenger.resources.bean.BeanParams;
import com.gcsreddy.restmessenger.service.ProfileService;
import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author gcsreddy
 */
@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
  
  private ProfileService profileService = new ProfileService();
  
  @GET
  public List<Profile> getProfiles(){
    return profileService.getAllProfiles();
  }
  
  @POST
  public Profile addProfile(Profile profile){
    return profileService.addProfile(profile);
  }
  
  @GET
  @Path("/{pName}")
  public Profile getProfile(@PathParam("pName") String profileName){
    
    return profileService.getProfile(profileName);
  }
  
  @PUT
  @Path("/{pName}")
  public Profile updateProfile(@PathParam("pName") String profileName,
          Profile profile){
    profile.setProfileName(profileName);
    profileService.updateProfile(profile);
    return profile;
  }
  
  @DELETE
  @Path("/{pName}")
  public Profile deleteProfile(@PathParam("pName") String profileName){
    return profileService.removeProfile(profileName);
  }
  
  //http://localhost:8080/restmessenger/
  //profiles/beanparams?ctry=US&st=MO&city=STL&zipcode=63102
  @GET
  @Path("/beanparams")
  public String getParamsFromBeanParam(@BeanParam BeanParams beanParamObj){
    return "bean params : Country="+beanParamObj.getCountry()
            +"State ="+beanParamObj.getState()
            +"City ="+beanParamObj.getCity()
            +"Zip ="+beanParamObj.getZip();
  }
  
}
