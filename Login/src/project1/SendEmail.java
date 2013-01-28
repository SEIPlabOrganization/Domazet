package project1;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

	public boolean send(String to, String sub, String cont) {
	
		final String username = "sptoolriteh@gmail.com";
		final String password = "qwerqwer12";
	
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
	
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
	
		try {
	
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("SPtoolRiteh@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
			message.setSubject(sub);
			message.setContent(cont, "text/html");
	
			Transport.send(message);
	
			return true;
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
