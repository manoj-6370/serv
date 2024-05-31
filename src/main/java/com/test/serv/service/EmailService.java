package com.test.serv.service;

import java.io.File;
import java.io.InputStream;

public interface EmailService {
    //send email to single persion
    void sendEmail (String to, String subject, String messege);
    //send email to multiple persion
    void sendEmail (String []to, String subject, String messege);
    //send email with HTML
    void sendEmailWithHtml(String to, String subject, String htmlcontent);
    //send email with file
    void sendEmailWithFile(String to, String subject, String message, InputStream is);


}
