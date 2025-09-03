package com.ibm.gestor.service;

import com.ibm.gestor.dtos.ReceitaDto;
import com.ibm.gestor.model.*;
import com.ibm.gestor.repositories.PessoaFisicaRepository;
import com.ibm.gestor.repositories.PessoaJuridicaRepository;
import com.ibm.gestor.repositories.ReceitaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    ReceitaRepository receitaRepository;
    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;
    @Autowired
    PessoaJuridicaRepository pessoaJuridicaRepository;

    @Transactional
    public Receita save(ReceitaDto receitaDto) {
        Pessoa pessoa = buscarPessoa(receitaDto.getTipoPessoa(), receitaDto.getPessoaId());

        Receita receita = Receita.builder()
                .nomeReceita(receitaDto.getNomeReceita())
                .valor(receitaDto.getValor())
                .origemEntrada(receitaDto.getOrigemEntrada())
                .dataEntrada(LocalDateTime.now(ZoneId.of("UTC")))
                .tipoPessoa(receitaDto.getTipoPessoa())
                .pessoa(pessoa)
                .build();

        return receitaRepository.save(receita);
    }

    public Page<Receita> getAll(Pageable pageable) { return receitaRepository.findAll(pageable); }

    public Optional<Receita> getById(Long id) { return receitaRepository.findById(id); }

    @Transactional
    public void delete(Receita receita) { receitaRepository.delete(receita); }

    @Transactional
    public Receita update(Long id, ReceitaDto receitaDto) {
        Receita receitaExistente = receitaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receita não encontrada"));

        Pessoa pessoa = buscarPessoa(receitaDto.getTipoPessoa(), receitaDto.getPessoaId());

        Receita receitaAtualizada = receitaExistente.toBuilder()
                .nomeReceita(receitaDto.getNomeReceita())
                .valor(receitaDto.getValor())
                .origemEntrada(receitaDto.getOrigemEntrada())
                .tipoPessoa(receitaDto.getTipoPessoa())
                .pessoa(pessoa)
                .build();

        return receitaRepository.save(receitaAtualizada);
    }

    private Pessoa buscarPessoa(@NotNull tipoPessoa tipo, Long id) {
        return switch (tipo) {
            case FISICA -> pessoaFisicaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Pessoa Física não encontrada"));
            case JURIDICA -> pessoaJuridicaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Pessoa Jurídica não encontrada"));
        };
    }

}
