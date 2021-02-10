package com.vastika.controller;

import com.vastika.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageController {
    @Autowired
    private MessageService messageService;

    public void send() {
        messageService.sendMessage("Hello, i am good");

    }
}
/////////////////////different ways of doing it//////////////////////////
//Step 1) traditional java method
//  Under controller class
/*    MessageService messageService = new EmailService();*/
//now we have to create an object of this class in java main file and call it's method from this class.

//Step 2)Another way to do this is we can creat a new @Bean in MessageConfiguration class like this
//    @Bean  public MessageService messageService(){ return new EmailService();

   //
    //This is a setter dependency injection for messageService and it needs to have @Bean in configuration class.
    //this way we don't need to load ApplicationContext and call context.getbean for every single @Beans.
   /*private MessageService messageService;
    @Autowired
    public void setMessageService(MessageService messageService){
        this.messageService = messageService;
    }
*/

