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
            //sms의 init메소드가 두 번 실행된다.
            //email객체가 소멸될 때 destroy 메서드가 한 번 실행된다.

            //scope가 prototype인 빈 객체에는 destroy 메서드를 설정해도 실행되지 않는다.
            //그 이유는 싱클톤 스코프의 경우 생성부터 종료까지 스프링 컨테이너가 관리해주지만
            //프로토타입의 경우 getBean이 언제 호출될지 몰라서 제어권??이 스프링 컨테이너에게 없어서 컨텍스트가 종료될 때
            //destroy메서드를 호출해주지 못한다.
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