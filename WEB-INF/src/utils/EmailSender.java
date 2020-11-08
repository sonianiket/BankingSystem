package utils;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.MessagingException;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Transport;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

public class EmailSender{

	static String message = "<div style='background-color:#10A881; width:90%; margin:5px auto; height:150px; border-radius:15px;'>"+
		"<h1 style='color:orange; font-weight:bold; text-align:center;margin-top:15px; padding-top:5px;'>Welcome ppp ...!<h1><hr>"+
		"<h4 style='color:white; text-align:center;'>Your form request has been approved by Admin</h4>"+
		"<h5 style='text-align:center;color:white'>Please Click over the <a href='ppp'>link</a> to activate your Account</h5></div>";
	
	static String info = "<div style='border:1px solid black; width:70%;margin:5px auto;border-radius:10px;'>"+
		"<h1 style='font-size:18px;margin-left:5%;color:orange'>Welcome..! ppp</h1>"+
		"<hr style='width:90%;'>"+
		"<h4 style='margin-left:5%;'>Your Password Reset Code Is: <span style='color:green;font-size:22px;'>ppp</span></h4>"+
	"</div>";
	public static void sendEmail(String name,String toEmail,String activationCode){
		Properties ppt = new Properties();
		ppt.put("mail.transport.protocol","smtp");
		ppt.put("mail.smtp.auth","true");
		ppt.put("mail.smtp.starttls.enable","true");
		ppt.put("mail.smtp.host","smtp.gmail.com");
		ppt.put("mail.smtp.port","587");

		Session session = Session.getInstance(ppt,new EmailAuthenticator());
		MimeMessage mmsg = new MimeMessage(session);

		try{
			mmsg.setFrom(new InternetAddress("tekinadeveloper@gmail.com"));
			mmsg.setRecipients(Message.RecipientType.TO,toEmail);
			mmsg.setSubject("Welcome !!!!");

			String link = "http://localhost:8080/Bank_Management/activate.do?email="+toEmail+"&activation_code="+activationCode;

			String [] arr = message.split("ppp");
			String msg = arr[0]+name+arr[1]+link+arr[2];

			mmsg.setContent(msg,"text/html");

			Transport.send(mmsg);


		}catch(MessagingException e){
			e.printStackTrace();
		}
	}

	public static void sendCode(String toEmail,String code){
		Properties ppt = new Properties();
		ppt.put("mail.transport.protocol","smtp");
		ppt.put("mail.smtp.auth","true");
		ppt.put("mail.smtp.starttls.enable","true");
		ppt.put("mail.smtp.host","smtp.gmail.com");
		ppt.put("mail.smtp.port","587");

		Session session = Session.getInstance(ppt,new EmailAuthenticator());
		MimeMessage mmsg = new MimeMessage(session);

		try{
			mmsg.setFrom(new InternetAddress("tekinadeveloper@gmail.com"));
			mmsg.setRecipients(Message.RecipientType.TO,toEmail);
			mmsg.setSubject("Welcome !!!!");
			String [] arr1 = info.split("ppp");
			String mesg = arr1[0]+toEmail+arr1[1]+code+arr1[2];

			mmsg.setContent(mesg,"text/html");

			Transport.send(mmsg);


		}catch(MessagingException e){
			e.printStackTrace();
		}
	}
}

class EmailAuthenticator extends Authenticator{
	public PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication("tekinadeveloper@gmail.com","advance_Java@2019");
	}
}