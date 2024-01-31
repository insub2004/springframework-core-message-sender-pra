package com.nhnacademy.edu.springframework.sender;

import com.nhnacademy.edu.springframework.domain.User;
import org.springframework.context.annotation.Configuration;

public class SmsMessageSender implements MessageSender{

    public SmsMessageSender() {
        System.out.println("SmsMessageSender initiated!!!");
    }

    public void init() {
        System.out.println("init method called in SmsMessageSender");
    }

    public void destroy() {
        System.out.println("destroy method called in SmsMessageSender");
    }
    @Override
    public void sendMessage(User user, String message) {
        System.out.println("SMS Message Sender : " + user.getPhoneNumber() + " : " + message);
    }
}
