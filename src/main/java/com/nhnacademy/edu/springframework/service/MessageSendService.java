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

public class MessageSendService {

    //final 키워드 이므로 객체를 생성한 뒤 greeter 변수에 값을 할당할 수 없다.
    //private final MessageSender messageSender;

    private MessageSender messageSender;

    @Value("${phoneNumber}")
    private String phoneNumber;

    //기본 생성자가 무조건 있어야함 왜냐 set주입을 사용할 것이기 때문에
//    public MessageSendService(){
//        System.out.println("service 기본 생성자 실행");
//    }
    @Autowired
    public MessageSendService(@CustomSms(kind = Kind.SMS, dummy = true) MessageSender messageSender){
        System.out.println("파라미터 1개 있는 생성자 실행");
        this.messageSender = messageSender;
    }

    public void doSendMessage(User user, String message) {
        System.out.println("변경 전 전화번호 : " + user.getPhoneNumber());
        user.setPhoneNumber(phoneNumber);
        System.out.println("변경 후 전화번호 : " + user.getPhoneNumber());
        messageSender.sendMessage(user, message);
    }
    
    public void setMessageSender(MessageSender messageSender) {
        System.out.println("set 메소드 실행!");
        this.messageSender = messageSender;
    }
}
