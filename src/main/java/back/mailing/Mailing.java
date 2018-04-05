package back.mailing;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailing {

	
	
	
	
	
    public void sendMessage( String email, String text, String subject)
    {
        try
        {
            // We set properties of the mailing configuration
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "put here your email account");
            props.setProperty("mail.smtp.auth", "true");

            // We begin a session to made transactions with it
            Session session = Session.getDefaultInstance(props);

            // Build the message with the information that we receive, email is the destinatary, the subject the topic of the 
            // email, finally the text is the message that we want to send
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.addRecipient( Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject(subject);
            message.setText(text);

            // We send it, and then we just close the conection.
            Transport t = session.getTransport("smtp");
            t.connect("put here your email account", "put here your password");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
	
	
	
}
