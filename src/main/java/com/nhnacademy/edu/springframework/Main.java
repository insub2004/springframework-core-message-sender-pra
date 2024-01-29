package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.sender.EmailMessageSender;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;
import com.nhnacademy.edu.springframework.service.MessageSendService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user = new User("윤인섭@naver.com", "010-2222-2222");

        MessageSendService messageSendService1 = new MessageSendService(new SmsMessageSender());
        MessageSendService messageSendService2 = new MessageSendService(new EmailMessageSender());

        messageSendService1.doSendMessage(user, "실습 2 sms");
        messageSendService2.doSendMessage(user, "실습 2 email");
    }

}