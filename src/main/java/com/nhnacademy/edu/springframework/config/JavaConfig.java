package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.annotation.CustomSms;
import com.nhnacademy.edu.springframework.annotation.Kind;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.SmsMessageSender;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/beans.xml")
public class JavaConfig {

    @Bean
    @CustomSms(kind = Kind.SMS, dummy = true)
    public SmsMessageSender smsMessageSender() {
        return new SmsMessageSender();
    }

}