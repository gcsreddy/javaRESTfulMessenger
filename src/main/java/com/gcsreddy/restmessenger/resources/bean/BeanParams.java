/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcsreddy.restmessenger.resources.bean;

import javax.ws.rs.QueryParam;

/**
 *
 * @author gcsreddy
 */
public class BeanParams {
  
  @QueryParam("ctry")
  private String country;
  @QueryParam("st")
  private String state;
  @QueryParam("city")
  private String city;
  @QueryParam("zipcode")
  private int zip;

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public int getZip() {
    return zip;
  }

  public void setZip(int zip) {
    this.zip = zip;
  }
  
  
}
