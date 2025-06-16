package com.ibm.gestor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.io.File;

@Service
public class SendEmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmail(String para, String assunto, String corpo, String pathAnexo) {
        try {
            MimeMessage mensagem = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mensagem, true);

            helper.setTo(para);
            helper.setSubject(assunto);
            helper.setText(corpo, false);
            helper.setFrom("igrejabatistamirantei@gmail.com");

            // Anexo opcional
            if (pathAnexo != null && !pathAnexo.isBlank()) {
                FileSystemResource arquivo = new FileSystemResource(new File(pathAnexo));
                if (arquivo.exists()) {
                    helper.addAttachment(arquivo.getFilename(), arquivo);
                } else {
                    throw new MessagingException("Arquivo não encontrado: " + pathAnexo);
                }
            }

            mailSender.send(mensagem);

        } catch (MessagingException e) {
            throw new RuntimeException("Erro ao enviar e-mail: " + e.getMessage(), e);
        }
    }
}
