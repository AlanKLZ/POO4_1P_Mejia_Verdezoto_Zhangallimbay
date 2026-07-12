package test;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Correo {

    public static void enviarCorreo(String destino, String asunto, String mensaje) {

        final String remitente = "tucorreo@gmail.com";
        final String contraseña = "abcdefghijklmnop"; // Contraseña de aplicación

        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(remitente, contraseña);
                    }
                });

        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(remitente));

            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(destino));

            message.setSubject(asunto);

            message.setText(mensaje);

            Transport.send(message);

            System.out.println("Correo enviado correctamente.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
