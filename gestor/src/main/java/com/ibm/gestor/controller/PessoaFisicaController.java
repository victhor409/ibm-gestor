package com.ibm.gestor.controller;

import com.ibm.gestor.model.PessoaFisica;
import com.ibm.gestor.service.PessoaFisicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pessoas-fisicas")
public class PessoaFisicaController {

    @Autowired
    PessoaFisicaService pessoaFisicaService;

    @GetMapping
    public ResponseEntity<Page<PessoaFisica>> getAllPessoasFisicas(
            @PageableDefault(page = 0, size = 10, sort = "nome") Pageable pageable) {

        return ResponseEntity.status(HttpStatus.OK).body(pessoaFisicaService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePessoaFisica(@PathVariable Long id) {
        Optional<PessoaFisica> pessoaFisicaOptional = pessoaFisicaService.getById(id);

        if (pessoaFisicaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa Física não encontrada!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(pessoaFisicaOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> createPessoaFisica(@RequestBody @Valid PessoaFisica pessoaFisica) {

        if (pessoaFisicaService.existsByCpf(pessoaFisica.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já cadastrado!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaFisicaService.save(pessoaFisica));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePessoaFisica(@PathVariable Long id, @RequestBody @Valid PessoaFisica pessoaFisica) {
        Optional<PessoaFisica> pessoaFisicaOptional = pessoaFisicaService.getById(id);
        if (pessoaFisicaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa Física não encontrada!");
        }

        PessoaFisica pessoaAtualizada = pessoaFisicaOptional.get();
        pessoaAtualizada.setNome(pessoaFisica.getNome());
        pessoaAtualizada.setEmail(pessoaFisica.getEmail());
        pessoaAtualizada.setEndereco(pessoaFisica.getEndereco());
        pessoaAtualizada.setTelefone(pessoaFisica.getTelefone());
        pessoaAtualizada.setCpf(pessoaFisica.getCpf());
        pessoaAtualizada.setSexo(pessoaFisica.getSexo());

        return ResponseEntity.status(HttpStatus.OK).body(pessoaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePessoaFisica(@PathVariable Long id) {
        Optional<PessoaFisica> pessoaFisicaOptional = pessoaFisicaService.getById(id);

        if (pessoaFisicaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa Física não encontrada");
        }

        pessoaFisicaService.delete(pessoaFisicaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa Física deletada.");
    }

}
