package com.LMS.genericUtils;

import com.LMS.base.BaseClass;
import org.testng.Reporter;
import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static com.LMS.base.Constants.EMAIL_FILE_PATH;

public class EmailUtils {

    public void sendMail(String subject,String body){
        Properties emailproperties = BaseClass.fileRead(EMAIL_FILE_PATH);
        final String username = emailproperties.getProperty("Fromusername");
        final String password = Encryption.decrypt(emailproperties.getProperty("FromPwdEncrypted"),
                Encryption.keyGenerator());

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
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
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailproperties.getProperty("tousername")));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            Reporter.log("# Mail sent.",true);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
