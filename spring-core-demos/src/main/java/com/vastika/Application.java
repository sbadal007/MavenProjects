package com.vastika;

import com.vastika.configuration.MessageConfiguration;
import com.vastika.controller.HelloController;
import com.vastika.controller.MessageController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
//normal method call
//        MessageController messageController = new MessageController();
//        messageController.send();

        //Call through Spring @bean method
        ApplicationContext context = new AnnotationConfigApplicationContext(MessageConfiguration.class);
        MessageController messageController = context.getBean(MessageController.class);
        messageController.send();

        System.out.println("==================================");
        HelloController helloController = context.getBean(HelloController.class);
        helloController.sayHello();
    }
}
