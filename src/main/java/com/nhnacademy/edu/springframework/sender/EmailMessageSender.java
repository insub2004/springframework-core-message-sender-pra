package com.nhnacademy.edu.springframework.sender;

import com.nhnacademy.edu.springframework.domain.User;

public class EmailMessageSender implements MessageSender{

    @Override
    public void sendMessage(User user, String message) {
        System.out.println("Email Message Sent : " + user.getEmail() + " : " + message);
    }
}
