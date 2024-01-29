package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.sender.EmailMessageSender;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user = new User("윤인섭@naver.com", "010-2222-2222");

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            //scope : 싱글톤이면 생성자 호출이 한 번
            //scope : prototype 이면 호출 될 때마다 생성자 호출
            System.out.println("--------------");
            new MessageSendService(context.getBean("smsMessageSender",MessageSender.class)).doSendMessage(user, "sms message");
            System.out.println("--------------");
            new MessageSendService(context.getBean("smsMessageSender",MessageSender.class)).doSendMessage(user, "sms message");
            System.out.println("--------------");
            new MessageSendService(context.getBean("emailMessageSender",MessageSender.class)).doSendMessage(user, "email message");
            System.out.println("--------------");
            new MessageSendService(context.getBean("emailMessageSender",MessageSender.class)).doSendMessage(user, "email message");
        }
    }

}