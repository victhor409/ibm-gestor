package com.ibm.gestor.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ibm.gestor.service.SendEmailService;


@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private SendEmailService emailService;

    @PostMapping("/enviar")
    public ResponseEntity<String> enviar(
            @RequestParam String para,
            @RequestParam String assunto,
            @RequestParam String corpo) {
        emailService.enviarEmail(para, assunto, corpo);
        return ResponseEntity.ok("Email enviado com sucesso!");
    }
}
