/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcsreddy.restmessenger.rest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author gcsreddy
 */
public class MyDateConverterProvider implements ParamConverterProvider{

  @Override
  public <T> ParamConverter<T> getConverter(final Class<T> rawType, 
          Type genericType, Annotation[] annotations) {
    if(rawType.getName().equals(MyDate.class.getName())){
      return new ParamConverter<T>() {
        @Override
        public T fromString(String value) {
          Calendar cal = Calendar.getInstance();
          if("tomorrow".equals(value)){
            cal.add(Calendar.DATE, 1);
          }else if("yesterday".equals(value)){
            cal.add(Calendar.DATE, -1);
          }
          MyDate mydate = new MyDate();
          mydate.setDay(cal.get(Calendar.DATE));
          mydate.setMonth(cal.get(Calendar.MONDAY));
          mydate.setYear(cal.get(Calendar.YEAR));
          
          return rawType.cast(mydate);
        }

        @Override
        public String toString(T value) {
          if(value == null){
            return null;
          }else{
            return value.toString();
          }
        }
      };
    }
    return null;
  }
  
}
