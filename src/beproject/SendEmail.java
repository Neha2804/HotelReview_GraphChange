package beproject;

   import java.util.Properties;    

import javax.mail.*;    
import javax.mail.internet.*;    
    class SendEmail{  
        public static final String from = "yojana.neebalit@gmail.com";
        public static final String password = "123456789ten";
        public static void send(String to,String sub,String msg){  
              //Get properties object    
              Properties props = new Properties();    
              props.put("mail.smtp.host", "smtp.gmail.com");    
              props.put("mail.smtp.socketFactory.port", "465");    
              props.put("mail.smtp.socketFactory.class",    
                        "javax.net.ssl.SSLSocketFactory");    
              props.put("mail.smtp.auth", "true");    
              props.put("mail.smtp.port", "465");    
              //get Session   
              Session session = Session.getDefaultInstance(props,    
               new javax.mail.Authenticator() {    
               protected PasswordAuthentication getPasswordAuthentication() {    
               return new PasswordAuthentication(from,password);  
               }    
              });    
              //compose message    
              try {    
               MimeMessage message = new MimeMessage(session);    
               message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
               message.setSubject(sub);    
               message.setText(msg); 
               message.setFrom(new InternetAddress(from));
               //send message  
               Transport.send(message);    
               System.out.println("message sent successfully");    
              } catch (MessagingException e) {throw new RuntimeException(e);}    
                 
        }  
        public static void main(String[] args) {    
            //from,password,to,subject,message  
            send("abc@gmail.com","hello javatpoint","How r u?");  
            //change from, password and to  
        }    
    }  

