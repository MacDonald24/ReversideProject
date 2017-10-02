/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrdfood.demo.boot.controller;

import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author User
 */
@Controller
public class SimpleEmailController {

    private JavaMailSender sender;
    @RequestMapping("/simpleemail")
    @ResponseBody
    String home() {

        try {

            sendEmail();

            return "Email Sent!";

        }catch(Exception ex) {

            return "Error in sending email: "+ex;

        }

    }

   private void sendEmail() throws Exception{
        MimeMessage message = sender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo("macdonaldnkoana@gmail.com");

        helper.setText("How are you?");

        helper.setSubject("Hi");


        sender.send(message);

    }

}
