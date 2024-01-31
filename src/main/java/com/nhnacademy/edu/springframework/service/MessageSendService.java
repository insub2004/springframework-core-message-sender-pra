package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.annotation.CustomSms;
import com.nhnacademy.edu.springframework.annotation.Kind;
import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.sender.EmailMessageSender;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageSendService {

    //final 키워드 이므로 객체를 생성한 뒤 greeter 변수에 값을 할당할 수 없다.
    //private final MessageSender messageSender;

    private MessageSender messageSender;

    @Value("${phoneNumber}")
    private String phoneNumber;

//    public MessageSendService(){
//        System.out.println("service 기본 생성자 실행");
//    }

    @Autowired
    public MessageSendService(@Qualifier("smsMessageSender") MessageSender messageSender){
        System.out.println("파라미터 1개 있는 생성자 실행");
        System.out.println(messageSender.hashCode());
        this.messageSender = messageSender;
    }

    public void doSendMessage(User user, String message) {
        System.out.println("변경 전 전화번호 : " + user.getPhoneNumber());
        user.setPhoneNumber(phoneNumber);
        System.out.println("변경 후 전화번호 : " + user.getPhoneNumber());
        messageSender.sendMessage(user, message);
    }

    public void setMessageSender(@Qualifier("smsMessageSender") MessageSender messageSender) {
        System.out.println("set 메소드 실행!");
        System.out.println(messageSender.hashCode());
        this.messageSender = messageSender;
    }
}
