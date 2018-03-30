package com.wh.house.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SendMail {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private RegisterCache registerCache;
    @Value("${spring.mail.username}")
    private String from;
    @Value("${domain.name}")
    private String domainName;

    public void sendMail(String mail,String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setText(content);
        simpleMailMessage.setTo(mail);
        simpleMailMessage.setSubject("欢迎注册");
        javaMailSender.send(simpleMailMessage);
    }

    @Async
    public void sendMail(String email) {
        // 发送邮件
        String verifyUrl = registerCache.createVerifyUrl(email);
        // 拼接字符串
        String mailContent = "http://"+domainName+"/verifyRegister?key="+verifyUrl;
        // 发送邮件
        sendMail(email,"请点击以下链接完成注册 "+mailContent);
    }

}
