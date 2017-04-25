package com.mashen.common.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailSender {
	public static void send(
			String[] receiveMails,
			String subject,
			String content,
			String contentType) throws  Throwable {
		Properties props=new Properties();
		props.setProperty("mail.smtp.host","smtp.exmail.qq.com");
		props.setProperty("mail.smtp.port", "25");
		props.setProperty("mail.smtp.auth","true");
		
		Session session=Session.getDefaultInstance(
				props, new Authenticator() {
					@Override
					protected PasswordAuthentication 
					getPasswordAuthentication() {
						return new PasswordAuthentication(
								"liushd@mashensoft.com",
								"Lsd1234567");
					}
				});
		session.setDebug(true);//打印详细的日志
		
		MimeMessage mineMessage=new 
				MimeMessage(session);
		//设置发件人
		mineMessage.setFrom(
				new InternetAddress("liushd@mashensoft.com"));
		InternetAddress[] receives=new InternetAddress[receiveMails.length];
		
		for(int i=0;i<receiveMails.length;i++){
			receives[i]=new InternetAddress(receiveMails[i]);
		}
		//设置收件人
		mineMessage.setRecipients(MimeMessage.RecipientType.TO,
				receives);
		//设置主题
		mineMessage.setSubject(subject);
		
		MimeMultipart multipart=new MimeMultipart();
		
		MimeBodyPart bodypart=new MimeBodyPart();
		bodypart.setContent(content,contentType);
		multipart.addBodyPart(bodypart);
		
		mineMessage.setContent(multipart);
		mineMessage.setSentDate(new Date());
		//发送邮件
		Transport.send(mineMessage);
		
	}
	public static void main(String[] args) throws Throwable {
		send(new String[]{"328429838@qq.com"},
				"主题","<html><body><img src=\"http://localhost/image/9184c7a0-8e50-4462-b0c2-8c871b85518c.jpg\"></body></html>","text/html;charset=utf-8");
		
	}
}
