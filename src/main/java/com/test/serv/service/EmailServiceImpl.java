package com.test.serv.service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender mailSender;

    private final Logger logger= LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public void sendEmail(String to, String subject, String messege) {
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setFrom("manojkumargiri784@gmail.com");
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(messege);

        mailSender.send(simpleMailMessage);
        logger.info("Email has been sent...");
    }

    @Override
    public void sendEmail(String[] to, String subject, String messege) {
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(messege);

        mailSender.send(simpleMailMessage);
        logger.info("message has been sent");

    }

    @Override
    public void sendEmailWithHtml(String to, String subject, String htmlcontent) {
        MimeMessage simpleMailMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper= new MimeMessageHelper(simpleMailMessage,true,"UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlcontent,true);
            mailSender.send(simpleMailMessage);
            logger.info("mail has been sent");


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void sendEmailWithFile(String to, String subject, String message, InputStream is) {
       MimeMessage mimeMessage=mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
            helper.setFrom("manojkumargiri784@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(message);
            File file =new File("serv/serv/src/main/resources/static/email/envelope.png");
            Files.copy(is,file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            FileSystemResource fsr=new FileSystemResource(file);
            helper.addAttachment(fsr.getFilename(),file);
            mailSender.send(mimeMessage);
            logger.info("mail sent: success");


        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }


    }
}
