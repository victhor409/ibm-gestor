package com.ibm.gestor.service;

import com.ibm.gestor.model.Pessoa;
import com.ibm.gestor.model.tipoPessoa;
import com.ibm.gestor.repositories.PessoaFisicaRepository;
import com.ibm.gestor.repositories.PessoaJuridicaRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

public class Utils {

    @Autowired
    static PessoaFisicaRepository pessoaFisicaRepository;
    @Autowired
    static PessoaJuridicaRepository pessoaJuridicaRepository;

    public static Pessoa buscarPessoa(@NotNull tipoPessoa tipo, Long id) {
        return switch (tipo) {
            case FISICA -> pessoaFisicaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Pessoa Física não encontrada"));
            case JURIDICA -> pessoaJuridicaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Pessoa Jurídica não encontrada"));
        };
    }

}
