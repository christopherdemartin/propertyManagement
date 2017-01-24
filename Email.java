import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Email {
	    public String emailFrom = "send.autoremind@gmail.com";
	    public String emailTo;
	    public String body;
	    public String subject;
	    public String SMTP_USERNAME = "AKIAJ7DK2IPIWPSYV26A";  // Replace with your SMTP username.
	    public String SMTP_PASSWORD = "Aj7qBQ6MQefYeqAUDCm/sa2r8J6a0uOnSwHeGctcvusN";  // Replace with your SMTP password.
	    public String HOST = "email-smtp.us-west-2.amazonaws.com";
	    public int PORT = 25;
	    	    
	    public void sendEmail(){
	    	Properties props = System.getProperties();
	    	props.put("mail.transport.protocol", "smtps");
	    	props.put("mail.smtp.port", PORT); 
	    	
	    	// Set properties indicating that we want to use STARTTLS to encrypt the connection.
	    	// The SMTP session will begin on an unencrypted connection, and then the client
	        // will issue a STARTTLS command to upgrade to an encrypted connection.
	    	props.put("mail.smtp.auth", "true");
	    	props.put("mail.smtp.starttls.enable", "true");
	    	props.put("mail.smtp.starttls.required", "true");
	        // Create a Session object to represent a mail session with the specified properties. 
	    	Session session = Session.getDefaultInstance(props);

	        // Create a message with the specified information. 
	    	try{
	        MimeMessage msg = new MimeMessage(session);
	        System.out.println("Preparing a message.");
	        msg.setFrom(new InternetAddress(this.emailFrom));
	        System.out.println("The message is from " + this.emailFrom);
	        //msg.setRecipient(Message.RecipientType.TO, new InternetAddress(this.to));
	        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(this.emailTo));
	        System.out.println("The message is to " + this.emailTo);
	        msg.setSubject(this.subject);
	        System.out.println("The message is about: " + this.subject);
	        msg.setContent(this.body,"text/plain");
	        System.out.println("Finished setting attributes and content.");
	            
	        // Create a transport.        
	        Transport transport = session.getTransport();
	                    
	        // Send the message.
	        try
	        {
	            System.out.println("Attempting to send an email through the Amazon SES SMTP interface...");
	            
	            // Connect to Amazon SES using the SMTP username and password you specified above.
	            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
	        	
	            // Send the email.
	            transport.sendMessage(msg, msg.getAllRecipients());
	            System.out.println("Email sent!");
	        }
	        catch (Exception ex) {
	            System.out.println("The email was not sent.");
	            System.out.println("Error message: " + ex.getMessage());
	        }
	        finally
	        {
	            // Close and terminate the connection.
	            transport.close();        	
	        }
	    	}
	    	catch (MessagingException e){
	    	System.out.println("Failed");
	    	}
	    }
	    
		public Email(String to, String body, String subject) {
			//super();
			this.emailTo = to;
			this.body = body;
			this.subject = subject;
			//sendEmail();
		}
	    
}


/* ORIGINAL CODE
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class AmazonSESSample {

    static final String FROM = "send.autoremind@gmail.com";   // Replace with your "From" address. This address must be verified.
    static final String TO = "tademartin@gmail.com";  // Replace with a "To" address. If your account is still in the 
                                                       // sandbox, this address must be verified.
    
    static final String BODY = "This is a test. This person's lease is up: Bob Saget";
    static final String SUBJECT = "Java send email through Amazon SES API";
    
    // Supply your SMTP credentials below. Note that your SMTP credentials are different from your AWS credentials.
    static final String SMTP_USERNAME = "AKIAJ7DK2IPIWPSYV26A";  // Replace with your SMTP username.
    static final String SMTP_PASSWORD = "Aj7qBQ6MQefYeqAUDCm/sa2r8J6a0uOnSwHeGctcvusN";  // Replace with your SMTP password.
    
    // Amazon SES SMTP host name. This example uses the US West (Oregon) region.
    static final String HOST = "email-smtp.us-west-2.amazonaws.com";    
    
    // The port you will connect to on the Amazon SES SMTP endpoint. We are choosing port 25 because we will use
    // STARTTLS to encrypt the connection.
    static final int PORT = 25;

    public static void main(String[] args) throws Exception {

        // Create a Properties object to contain connection configuration information.
    	Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtps");
    	props.put("mail.smtp.port", PORT); 
    	
    	// Set properties indicating that we want to use STARTTLS to encrypt the connection.
    	// The SMTP session will begin on an unencrypted connection, and then the client
        // will issue a STARTTLS command to upgrade to an encrypted connection.
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.starttls.required", "true");

        // Create a Session object to represent a mail session with the specified properties. 
    	Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information. 
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        msg.setSubject(SUBJECT);
        msg.setContent(BODY,"text/plain");
            
        // Create a transport.        
        Transport transport = session.getTransport();
                    
        // Send the message.
        try
        {
            System.out.println("Attempting to send an email through the Amazon SES SMTP interface...");
            
            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
        	
            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
        finally
        {
            // Close and terminate the connection.
            transport.close();        	
        }
    }
}

*/