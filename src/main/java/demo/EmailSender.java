package demo;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailSender {

	public static void main(String[] args) {
		final String senderEmail = "umeshreddy8222@gmail.com";
		final String appPassword = "jmbp qxop pram bdij";
		final String receiverEmail = "umeshreddy8222@gmail.com";
		// SMTP server properties
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.port", "587");
		// Create a session with authentication
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, appPassword);
			}
		});
		session.setDebug(true);

		try {
			// create Email Message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail));
			message.setSubject("Test email from QA Automation");
//			message.setText("Hello \n This is a text email from java \n regards \n QA Team");
			//Email Body Part
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText("Hello \\n \\n This is a text email from java \\n \\n regards \\n QA Team");
			
			//Attachments Part
			MimeBodyPart attachmentPart = new MimeBodyPart();
			String filePath = System.getProperty("user.dir")+"/reports/ExtentReport.html";
			attachmentPart.attachFile(new File(filePath));
			
			//combine body and attachment parts
			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(textPart);
			multipart.addBodyPart(attachmentPart);
			message.setContent(multipart);
			// Send Email
			Transport.send(message);
			System.out.println("Email sent successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
