package com.vastika.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("textService")
public class TextService implements MessageService{

    @Value("${user.mobile_no}")
    String mobile_no ;

    public void sendMessage(String msg) {
        System.out.println(msg+"is sent to " +mobile_no);
    }
}
