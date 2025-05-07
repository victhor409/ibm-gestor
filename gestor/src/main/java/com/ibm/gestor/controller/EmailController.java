package com.ibm.gestor.controller;

import com.ibm.gestor.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private SendEmailService emailService;

    @PostMapping("/enviar")
    public ResponseEntity<String> enviar(
            @RequestParam String para,
            @RequestParam String assunto,
            @RequestParam String corpo,
            @RequestParam(required = false) String path_anexo
    ) {
        emailService.enviarEmail(para, assunto, corpo, path_anexo);
        return ResponseEntity.ok("Email enviado com sucesso!");
    }
}
