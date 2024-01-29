package com.nhnacademy.edu.springframework.sender;

import com.nhnacademy.edu.springframework.domain.User;

public class SmsMessageSender implements MessageSender{

    public SmsMessageSender(){
        System.out.println("SmsMessageSender initiated!!!");
    }
    @Override
    public void sendMessage(User user, String message) {
        System.out.println("SMS Message Sender : " + user.getPhoneNumber() + " : " + message);
    }
}
