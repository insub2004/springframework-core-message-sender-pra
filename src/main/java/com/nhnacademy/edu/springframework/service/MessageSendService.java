package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;

public class MessageSendService {

    //final 키워드 이므로 객체를 생성한 뒤 greeter 변수에 값을 할당할 수 없다.
    //private final MessageSender messageSender;

    private MessageSender messageSender;

    //기본 생성자 추가
    public MessageSendService(){
        System.out.println("service 기본 생성자 실행");
    }

    public MessageSendService(MessageSender messageSender){
        this.messageSender = messageSender;
    }

    public void doSendMessage(User user, String message) {
        messageSender.sendMessage(user, message);
    }

    // set추가
    public void setMessageSender(MessageSender messageSender) {
        System.out.println("set 메소드 실행!");
        this.messageSender = messageSender;
    }

}
