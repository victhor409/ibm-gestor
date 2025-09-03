package com.ibm.gestor.controller;

import com.ibm.gestor.model.PessoaJuridica;
import com.ibm.gestor.service.PessoaJuridicaService;
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
@RequestMapping("/pessoas-juridicas")
public class PessoaJuridicaController {

    @Autowired
    PessoaJuridicaService pessoaJuridicaService;

    @GetMapping
    public ResponseEntity<Page<PessoaJuridica>> getAllPessoasJuridicas(
            @PageableDefault(page = 0, size = 10, sort = "nome") Pageable pageable) {

        return ResponseEntity.status(HttpStatus.OK).body(pessoaJuridicaService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePessoaJuridica(@PathVariable Long id) {
        Optional<PessoaJuridica> pessoaJuridicaOptional = pessoaJuridicaService.getById(id);

        if (pessoaJuridicaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa Jurídica não encontrada!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(pessoaJuridicaOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> createPessoaJuridica(@RequestBody @Valid PessoaJuridica pessoaJuridica) {

        if (pessoaJuridicaService.existsByCnpj(pessoaJuridica.getCnpj())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CNPJ já cadastrado!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaJuridicaService.save(pessoaJuridica));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePessoaJuridica(@PathVariable Long id, @RequestBody @Valid PessoaJuridica pessoaJuridica) {
        Optional<PessoaJuridica> pessoaJuridicaOptional = pessoaJuridicaService.getById(id);

        if (pessoaJuridicaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa Jurídica não encontrada!");
        }

        PessoaJuridica pessoaAtualizada = pessoaJuridicaOptional.get();
        pessoaAtualizada.setNome(pessoaJuridica.getNome());
        pessoaAtualizada.setEmail(pessoaJuridica.getEmail());
        pessoaAtualizada.setEndereco(pessoaJuridica.getEndereco());
        pessoaAtualizada.setTelefone(pessoaJuridica.getTelefone());
        pessoaAtualizada.setCnpj(pessoaJuridica.getCnpj());

        return ResponseEntity.status(HttpStatus.OK).body(pessoaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePessoaJuridica(@PathVariable Long id) {
        Optional<PessoaJuridica> pessoaJuridicaOptional = pessoaJuridicaService.getById(id);

        if (pessoaJuridicaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa Jurídica não encontrada!");
        }

        pessoaJuridicaService.delete(pessoaJuridicaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa Jurídica deletada.");
    }

}
