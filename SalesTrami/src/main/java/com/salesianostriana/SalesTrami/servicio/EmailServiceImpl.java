package com.salesianostriana.SalesTrami.servicio;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl {

    private final JavaMailSender javaMailSender;

    public void sendMail (String toEmail, String asunto, String mensaje) {

        var mailMessage = new SimpleMailMessage ();

        mailMessage.setTo (toEmail);
        mailMessage.setSubject (asunto);
        mailMessage.setText (mensaje);

        mailMessage.setFrom ("adrinjndro@gmail.com");

        javaMailSender.send (mailMessage);
    }
}
