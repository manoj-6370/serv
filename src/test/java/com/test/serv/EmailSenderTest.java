package com.test.serv;

import com.test.serv.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
public class EmailSenderTest {
    @Autowired
    private EmailService emailService;

    @Test
    void EmailSendTest(){
        System.out.println("sending Email");
        emailService.sendEmail("manoj637029@gmail.com","send from spring-boot","i am sending email");
    }
    @Test
    void sendHtmlInEmail(){
        System.out.println("sending Email");
        String html="<h1 style='color:red;border:1px solid gray'>Welcome to the Jungle</h1>"
                +"<a href=\"https:/" +
                "/www.youtube.com/\" >youtube</a>";
        emailService.sendEmailWithHtml("manoj637029@gmail.com","send from spring-boot",html);

    }
    @Test
    void EmailsSendTest(){
        String a[]={"manoj637029@gmail.com","manojkumargiri007@gmail.com"};
        System.out.println("sending Email");
        emailService.sendEmail(a,"send from spring-boot","i am sending email");
    }

//    @Test
//    void EmailSendFileTest(){
//        System.out.println("sending Email");
//        File file =new File("C:\\\\Users\\\\user\\\\Desktop\\\\Intelli-projects\\\\serv\\\\serv\\\\src\\\\main\\\\resources\\\\static\\\\img\\\\signature.png");
//        emailService.sendEmailWithFile("manoj637029@gmail.com","send from spring-boot","i am sending email",file);
//    }

}
