package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.annotation.CustomSms;
import com.nhnacademy.edu.springframework.annotation.Kind;
import com.nhnacademy.edu.springframework.sender.EmailMessageSender;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("com.nhnacademy.edu.springframework")
public class JavaConfig {
//
//    @Bean
//    @CustomSms(kind = Kind.SMS, dummy = true)
//    public SmsMessageSender smsMessageSender() {
//        return new SmsMessageSender();
//    }
//
//    @Bean
//    public EmailMessageSender emailMessageSender() {return new EmailMessageSender()}
//
//    @Bean
//    public MessageSendService messageSendService() {
//        return new MessageSendService(smsMessageSender());
//    }
//
//
}