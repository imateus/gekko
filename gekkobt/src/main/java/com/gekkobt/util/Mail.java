package com.gekkobt.util;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;

import com.gekkobt.environment.EnvironmentVariables;

public class Mail {

	@SuppressWarnings("unused")
	private String lookupMXServer() throws NamingException {
		String domainName = EnvironmentVariables.getDashboardProperties()
				.getValue("mail.domain.name");
		InitialDirContext iDirC = new InitialDirContext();

		Attributes attributes = iDirC.getAttributes("dns:/" + domainName,
				new String[] { "MX" });
		Attribute attributeMX = attributes.get("MX");
		String smtpServer = null;
		Integer priority = null;
		for (int i = 0; i < attributeMX.size(); i++) {
			String email = ((String) attributeMX.get(i)).split("\\s+")[1];
			String priorityTemp = ((String) attributeMX.get(i)).split("\\s+")[0];
			if (priority == null) {
				priority = Integer.parseInt(priorityTemp);
				smtpServer = email.substring(0, email.length() - 1);
			}
			if (Integer.parseInt(priorityTemp) < priority) {
				smtpServer = email.substring(0, email.length() - 1);
			}
		}
		return smtpServer;
	}

	public void sendMail(String Userpassword, String email) {
		try {
			String smtpServer = "webmail.resource.com.br";
			System.out.println();
			/*String smtpServer = lookupMXServer();*/
			final String username = EnvironmentVariables
					.getDashboardProperties().getValue("mail.user");
			final String password = EnvironmentVariables
					.getDashboardProperties().getValue("mail.password");
			String from = EnvironmentVariables.getDashboardProperties()
					.getValue("mail.dashboard");
			String port = EnvironmentVariables.getDashboardProperties()
					.getValue("mail.port");

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", smtpServer);
			props.put("mail.smtp.port", port);

			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username,
									password);
						}
					});
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject("Recuperação de senha - Equipe Gekko Bug Tracker.");
			message.setText("Olá sua senha é: "+ Userpassword+"\n \n Atenciosamente,\n Equipe Gekko Bug Tracker");
			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void sendMail(String title, String msg, List<String> emails) {
		if (emails != null) {
			for (String email : emails) {
				sendMail(title, msg);
			}
		}
	}

}