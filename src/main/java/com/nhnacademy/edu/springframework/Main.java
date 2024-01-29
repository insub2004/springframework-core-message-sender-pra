package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.domain.User;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user = new User("윤인섭@naver.com", "010-2222-2222");

        Main mainInstance = new Main();
        mainInstance.sendSmsMessage(user, " 실습 1번");
    }

    private void sendSmsMessage(User user, String message) {
        System.out.println("SMS Message Sent to " + user.getPhoneNumber() + message);
    }

    private void sendEmailMessage(User user, String message) {
        System.out.println("Email Message Sent to " + user.getEmail() + message);
    }
}