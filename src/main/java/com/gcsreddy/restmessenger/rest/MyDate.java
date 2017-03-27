/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcsreddy.restmessenger.rest;

/**
 *
 * @author gcsreddy
 */
public class MyDate {
  private int day;
  private int month;
  private int year;

  

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }
  
  @Override
  public String toString(){
    return "day = "+ this.day + " month = "+this.month+" year = "+this.year;
  }
  
}
