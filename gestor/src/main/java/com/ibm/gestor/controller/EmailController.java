package com.ibm.gestor.controller;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public ResponseEntity<String> enviar(
            @RequestParam String para,
            @RequestParam String assunto,
            @RequestParam String corpo) {
        emailService.enviarEmail(para, assunto, corpo);
        return ResponseEntity.ok("Email enviado com sucesso!");
    }
}
