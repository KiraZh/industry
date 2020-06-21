package team.fta.industry.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class SpringMail {
    /**
     * 发送邮件
     *
     * @param subject 邮件主题
     * @param context 邮件内容
     * @param to      收件方
     */
    public static void sendMail(String subject, String context, String to) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-mail.xml");
        SimpleMailMessage mailMessage = (SimpleMailMessage) ac.getBean("mailMessage");
        mailMessage.setSubject(subject);
        mailMessage.setText(context);
        mailMessage.setTo(to);
        JavaMailSenderImpl mailSender = (JavaMailSenderImpl) ac.getBean("mailSender");
        mailSender.send(mailMessage);
    }

}