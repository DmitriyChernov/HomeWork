package EmailSend;

import java.util.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage.RecipientType;

public class Emailer 
{

    private static String HOST = "smtp.gmail.com";
    private static String USER = "chernovdmitriy2011@gmail.com";
    private static String PASSWORD = "dhjnvytyjub";
    private static String PORT = "465";
    private static String FROM = "chernovdmitriy2011@gmail.com";
    private static String TO = "chernovdmitriy2011@gmail.com";
    private static String filename1 = "D:/study/builder/export.txt";
    private static String filename2 = "D:/study/builder/compiling.txt";
    private static String STARTTLS = "true";
    private static String AUTH = "true";
    private static String DEBUG = "true";
    private static String SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";
    private static String SUBJECT = "Build";
    private static String TEXT = "Build was not successfull! Please read logs!";
    private static String SUCTEXT = "Build was successfull!";
    
    public static synchronized void send(boolean isBuildSuccessfull) 
    {
        //Use Properties object to set environment properties
        Properties props = new Properties();

        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.user", USER);

        props.put("mail.smtp.auth", AUTH);
        props.put("mail.smtp.starttls.enable", STARTTLS);
        props.put("mail.smtp.debug", DEBUG);

        props.put("mail.smtp.socketFactory.port", PORT);
        props.put("mail.smtp.socketFactory.class", SOCKET_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");

        try 
        {

            //Obtain the default mail session
            Session session = Session.getDefaultInstance(props, null);
            session.setDebug(true);

            //Construct the mail message
            MimeMessage message = new MimeMessage(session);
            message.setSubject(SUBJECT);
            message.setFrom(new InternetAddress(FROM));
            message.addRecipient(RecipientType.TO, new InternetAddress(TO));
            message.saveChanges();
            
            if (isBuildSuccessfull)
            {
                message.setText(SUCTEXT);
            }
            else
            {
                Multipart mp = new MimeMultipart();

                //Text part
                MimeBodyPart htmlPart = new MimeBodyPart();
                htmlPart.setContent(TEXT, "text");
                mp.addBodyPart(htmlPart);

                //Export.txt part
                MimeBodyPart export = new MimeBodyPart();
                export.setFileName(filename1);
                DataSource source = new FileDataSource(filename1);
                export.setDataHandler(new DataHandler(source));
                export.setFileName(MimeUtility.encodeText(source.getName()));
                mp.addBodyPart(export);

                //Compiling.txt part
                MimeBodyPart compile = new MimeBodyPart();
                compile.setFileName(filename1);
                DataSource source1 = new FileDataSource(filename2);
                compile.setDataHandler(new DataHandler(source1));
                compile.setFileName(MimeUtility.encodeText(source1.getName()));
                mp.addBodyPart(compile);

                //Сборка
                message.setContent(mp);
            }
            //Use Transport to deliver the message
            Transport transport = session.getTransport("smtp");
            transport.connect(HOST, USER, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) 
    {
       if ("yes".equals(args[0]))
       {
           Emailer.send(true);
       }
       else
       {
           Emailer.send(false);
      }
       System.out.println("Mail sent successfully!");
    }
}