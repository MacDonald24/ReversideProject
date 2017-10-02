package com.mrdfood.demo.boot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.stereotype.Controller;


@Controller
public class EmailUtil{
    /*
    spring.mail.host=smtp.gmail.com
2
spring.mail.port=587
3
spring.mail.username=username
4
spring.mail.password=password
5
spring.mail.properties.mail.smtp.starttls.enable=true
6
spring.mail.properties.mail.smtp.starttls.required=true
7
spring.mail.properties.mail.smtp.auth=true
8
spring.mail.properties.mail.smtp.connectiontimeout=5000
9
spring.mail.properties.mail.smtp.timeout=5000
10
spring.mail.properties.mail.smtp.writetimeout=5000

    
    
  */
    private static Logger logger = LoggerFactory.getLogger(EmailUtil.class);
    private JavaMailSender sender;
    private final static Properties smtpProperties;

    static {
        smtpProperties = new Properties();

        smtpProperties.put("spring.mail.host","smtp.gmail.com");
        smtpProperties.put("spring.mail.port",  587);
        smtpProperties.put("spring.mail.username","macdonaldnkoana@gmaiil.com");
        smtpProperties.put("spring.mail.password", "macdOM25@m"); //SSL Port
        smtpProperties.put("spring.mail.properties.mail.smtp.starttls.enable",true);
        smtpProperties.put("spring.mail.properties.mail.smtp.starttls.required", true);
        smtpProperties.put("spring.mail.properties.mail.smtp.auth", true);
        smtpProperties.put("spring.mail.properties.mail.smtp.connectiontimeout",5000 ); //SSL Port
        smtpProperties.put("spring.mail.properties.mail.smtp.timeout", 5000);
        smtpProperties.put("spring.mail.properties.mail.smtp.writetimeout", 5000); //SSL Port
      
    }
    
      public void sendEmail(String toAddress, String subject, String body) {
   

          try
          {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setTo(toAddress);
            helper.setText(body);

            helper.setSubject(subject);

            sender.send(message);
          }catch(MailException ex)
          {
              
          } catch (MessagingException ex) {
            java.util.logging.Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       

}
