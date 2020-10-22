package com.salesianostriana.SalesTrami.servicio;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;

@Service
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail (String toEmail, String asunto, String mensaje) {

        SimpleMailMessage mailMessage = new SimpleMailMessage ();

        mailMessage.setTo (toEmail);
        mailMessage.setSubject (asunto);
        mailMessage.setText (mensaje);

        mailMessage.setFrom("adriandiazs1999@gmail.com");

        javaMailSender.send (mailMessage);
    }
}
