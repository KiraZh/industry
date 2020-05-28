package team.fta.industry.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class SpringMail {
    public void sendMail(String subject, String context, String to){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-mail.xml");
        SimpleMailMessage mailMessage = (SimpleMailMessage) ac.getBean("mailMessage");
        mailMessage.setSubject(subject);
        mailMessage.setText(context);
        mailMessage.setTo(to);
        JavaMailSenderImpl mailSender = (JavaMailSenderImpl) ac.getBean("mailSender");
        mailSender.send(mailMessage);
    }
    
}