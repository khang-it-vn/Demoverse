package com.Demoverse.Logic;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class MailUtil {
    public static void sendMail(String recepient) throws Exception {
        System.out.println("preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        String myAccountEmail = "demoversevn@gmail.com";
        String password = "1234567890Tk.";
        Session session = Session.getInstance(properties ,  new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail,password);
            }
        });
        Message message = prepareMessage(session,myAccountEmail, recepient);
        Transport.send(message);
        System.out.println("message send successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Ma Xac Nhan Kich Hoat Tai Khoan Demoverse"); // tieue dde cua mail
            Random random = new Random();
            int val =  random.nextInt(100000);
            message.setText("Xin chao, \n Ma xac nhan email cua ban la " +val);// noi dung ben trong mail
            return message;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
