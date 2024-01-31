package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user = new User("윤인섭@naver.com", "010-2222-2222");

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {

            // 이제 xml에 있는 messageSender 빈 객체들을 가져와서 호출해주지 않고
            // messageSenderService를 빈 객체로 만들고 생성자 주입 방식으로 messageSender 빈 객체를 주입해준다.
            MessageSendService messageSendService = context.getBean("messageSendService",MessageSendService.class);
            messageSendService.doSendMessage(user,"DI 실습02");
        }
    }

}