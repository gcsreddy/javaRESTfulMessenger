/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcsreddy.restmessenger.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gcsreddy
 */
@XmlRootElement
public class ErrorMessage {
  private String errorMessage;
  private int errorCode;
  private String documentation;

  public ErrorMessage(String errorMessage, int errorCode, String documentation) {
    this.errorMessage = errorMessage;
    this.errorCode = errorCode;
    this.documentation = documentation;
  }

  public ErrorMessage() {
  }

  
  
  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public String getDocumentation() {
    return documentation;
  }

  public void setDocumentation(String documentation) {
    this.documentation = documentation;
  }
  
  
}
