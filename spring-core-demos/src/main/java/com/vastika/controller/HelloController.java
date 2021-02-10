package com.vastika.controller;

import com.vastika.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HelloController {

////////////////////Field based injection//////////////////////////////////////
    @Autowired
    @Qualifier("textService")
    private MessageService messageService;

////////////////////////// Constructor based injection ////////////////////////////////
    //with constructor based injection no need to do @Autowired too
    //@Autowired
    /*private final MessageService messageService;
    public HelloController(@Qualifier("textService") MessageService messageService) {
        this.messageService = messageService;
    }*/
/////////////////////////////////////////////////////////////////////////////////

    public void sayHello(){
        messageService.sendMessage("Hello ");
    }
}
