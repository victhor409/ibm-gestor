package com.ibm.gestor.service;

@Service
public class SendEmailService {

    @Autowired
    private final JavaMailSender mailSender;

    public void enviarEmail(String para, String assunto, String corpo) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(para);
        mensagem.setSubject(assunto);
        mensagem.setText(corpo);
        mensagem.setFrom("SEU_EMAIL@gmail.com");

        mailSender.send(mensagem);
        return "Enviado!";
    }
}
