package com.test.serv.controller;

import com.test.serv.helper.CustomResponse;
import com.test.serv.helper.EmailRequest;
import com.test.serv.service.EmailService;
import jakarta.mail.Multipart;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@MultipartConfig
@CrossOrigin
public class EmailController {
    @Autowired
    private EmailService emailService;
    @PostMapping(value="/sendWithFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CustomResponse> SendEmailWithFile(@RequestPart EmailRequest request, @RequestPart MultipartFile file)throws IOException{

            try {
                emailService.sendEmailWithFile(request.getTo(), request.getSubject(), request.getMessage(), file.getInputStream());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        return ResponseEntity.ok(
             CustomResponse.builder().message("email sent successfully").httpStatus(HttpStatus.OK).success(true).build()
     );
    }

    @PostMapping(value="/send")
    public ResponseEntity<CustomResponse> SendEmail(@RequestBody EmailRequest request){

        try {
            emailService.sendEmail(request.getTo(), request.getSubject(), request.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(
                CustomResponse.builder().message("email sent successfully").httpStatus(HttpStatus.OK).success(true).build()
        );
    }


}
