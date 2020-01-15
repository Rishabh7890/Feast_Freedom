package com.feastfreedom.feastfreedom;


import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mailService {

	
				// order confirmation
	public static void confMail(String user1,String kitchen1)throws Exception {
		
		System.out.println("connecting to server.......");
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
	    final String myEmail= "feast.freedom.project@gmail.com";
		final String password= "summitworks";
		
		Session session=Session.getInstance(properties, new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(myEmail, password) ;
				
			}
		});
			
		Message message=prepareMessage(session,myEmail,user1);
		Transport.send(message);
		System.out.println("email been sent to user");
		Message message1=prepareMessage1(session,myEmail,kitchen1);
		Transport.send(message1);
		System.out.println("email been sent to kitchen");
	}

	private static Message prepareMessage(Session session, String myEmail, String kitchen1) {
		// TODO Auto-generated method stub
		
		try {
			Message message= new MimeMessage(session);
			message.setFrom(new InternetAddress(myEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(kitchen1));
			message.setSubject("this is java msg");
			message.setText("hello \n you have a new order \n Please check your orders list.");
			return message;
			
		}catch(Exception ex) {
			Logger.getLogger(mailService.class.getName()).log(Level.SEVERE,null,ex);
		}
		
		return null;
	}
	private static Message prepareMessage1(Session session, String myEmail, String user1) {
		// TODO Auto-generated method stub
		
		try {
			Message message1= new MimeMessage(session);
			message1.setFrom(new InternetAddress(myEmail));
			message1.setRecipient(Message.RecipientType.TO, new InternetAddress(user1));
			message1.setSubject("this is java msg");
			message1.setText("Congratulations, \n your is created successful. ");
			return message1;
			
		}catch(Exception ex) {
			Logger.getLogger(mailService.class.getName()).log(Level.SEVERE,null,ex);
		}
		
		return null;
	}
					
				// user created
	
public static void userCreated(String userEmail)throws Exception {
		
		System.out.println("connecting to server.......");
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
	    final String myEmail= "feast.freedom.project@gmail.com";
		final String password= "summitworks";
		
		Session session=Session.getInstance(properties, new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(myEmail, password) ;
				
			}
		});
			
		Message message2=prepareMessage2(session,myEmail,userEmail);
		Transport.send(message2);
		System.out.println("user confirmation email sent");
	}

	private static Message prepareMessage2(Session session, String myEmail, String userEmail) {
		// TODO Auto-generated method stub
		
		try {
			Message message= new MimeMessage(session);
			message.setFrom(new InternetAddress(myEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
			message.setSubject("Dont Reply");
			message.setText("Congratulations, \n Your profile been created.");
			return message;
			
		}catch(Exception ex) {
			Logger.getLogger(mailService.class.getName()).log(Level.SEVERE,null,ex);
		}
		
		return null;
	}
	
				//kitchen created
	
public static void kitchenCreated(String kitchenEmail)throws Exception {
		
		System.out.println("connecting to server.......");
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
	    final String myEmail= "feast.freedom.project@gmail.com";
		final String password= "summitworks";
		
		Session session=Session.getInstance(properties, new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(myEmail, password) ;
				
			}
		});
			
		Message message3=prepareMessage3(session,myEmail,kitchenEmail);
		Transport.send(message3);
		System.out.println("kitchen confirmation email sent");
	}

	private static Message prepareMessage3(Session session, String myEmail, String kitchenEmail) {
		// TODO Auto-generated method stub
		
		try {
			Message message= new MimeMessage(session);
			message.setFrom(new InternetAddress(myEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(kitchenEmail));
			message.setSubject("Dont Reply");
			message.setText("Congratulations, \n Your kitchen profile been created.");
			return message;
			
		}catch(Exception ex) {
			Logger.getLogger(mailService.class.getName()).log(Level.SEVERE,null,ex);
		}
		
		return null;
	}
}