package com.vastika.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EmailService implements MessageService{

    @Value("${user.email}")
    private String email;
    public void sendMessage(String msg) {
        System.out.println(msg + " is sent to " + email);
    }
}
