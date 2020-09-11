package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailService {
    @Autowired
    private JavaMailSenderImpl javaMailSender;
    //简单邮件测试
    public void sendSimple(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("email测试");
        message.setText("邮件测试内容");
        message.setTo("877230620@qq.com");
        message.setFrom("877230620@qq.com");
        javaMailSender.send(message);
    }
    //复杂邮件测试
    public void sendComplicated() throws MessagingException {
        //创建一个复杂的消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //用MimeMessageHelper来包装MimeMessage
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setSubject("email测试");
        mimeMessageHelper.setText("邮件测试内容");
        mimeMessageHelper.setTo("877230620@qq.com");
        mimeMessageHelper.setFrom("877230620@qq.com");
        mimeMessageHelper.addAttachment("meinv.jpg",new File("D:\\meinv.jpg"));
        javaMailSender.send(mimeMessage);

    }
}