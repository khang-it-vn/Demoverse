package com.Demoverse.Logic;


import com.Demoverse.Entities.Users;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;

public class MailUtil {
    public static void sendMail(Users users) throws Exception {
        System.out.println("preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        String myAccountEmail = "demoversevn@gmail.com";
        String password = "%damhackmailtao%%<>%";
        Session session = Session.getInstance(properties ,  new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail,password);
            }
        });
        Message message = prepareMessage(session,myAccountEmail, users);
        Transport.send(message);
        System.out.println("message send successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, Users users) {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(users.getEmail()));
            message.setSubject("Xac Nhan Kich Hoat Tai Khoan Demoverse"); // tieue dde cua mail
            String username_convert_url = URLEncoder.encode(users.getUsername(),"UTF-8");
            message.setText("Xin chao, \n Link xac nhan tao tai khoan Demoverse cua ban la " + "http://localhost:8080/Demoverse_war_exploded/confirm?email="+users.getEmail()+"&username="+username_convert_url+"&password="+users.getPass());// noi dung ben trong mail
            return message;
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
