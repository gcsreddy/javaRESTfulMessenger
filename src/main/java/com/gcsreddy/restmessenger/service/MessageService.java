/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcsreddy.restmessenger.service;

import com.gcsreddy.restmessenger.database.DatabaseClass;
import com.gcsreddy.restmessenger.model.Message;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gcsreddy
 */
public class MessageService {

  public MessageService() {
    Message m1 = new Message(1L, "Hello World", "gcsreddy");
    Message m2 = new Message(2L, "Hello World 2", "reddy");
    this.addMessage(m1);
    this.addMessage(m2);
  }
  
  
  private Map<Long, Message> messages = DatabaseClass.getMessages();
          
  public List<Message> getAllMessages(){
    
//    Message m1 = new Message(1L, "Hello World", "gcsreddy");
//    Message m2 = new Message(2L, "Hello World 2", "reddy");
//    
//    return Arrays.asList(m1, m2);

      return new ArrayList<>(messages.values());
  }
  
  public List<Message> getAllMessagesForYear(int year){
    List<Message> messagesForYear = new ArrayList<>();
    Calendar cal = Calendar.getInstance();
    for(Message msg : messages.values()){
      cal.setTime(msg.getCreated());
      if(cal.get(Calendar.YEAR) == year){
        messagesForYear.add(msg);
      }
    }
    return messagesForYear;
  }
  
  public List<Message> getAllMessagesPaginated(int start, int size){
    
    return new ArrayList<>(messages.values()).subList(start, start+size);
  }
  
  public Message getMessage(long id){
    return messages.get(id);
  }
  
  public Message addMessage(Message message){
    message.setId(messages.size()+1);
    messages.put(message.getId(), message);
    return message;
  }
  
  public Message updateMessage(Message message){
    if(message.getId() <= 0){
      return null;
    }
    messages.put(message.getId(), message);
    
    return message;
  }
  
  public Message removeMessage(long id){
    return messages.remove(id);
  }
}
