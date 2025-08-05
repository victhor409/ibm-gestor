package com.ibm.gestor.service;

import com.ibm.gestor.dtos.ReceitaDto;
import com.ibm.gestor.model.PessoaFisica;
import com.ibm.gestor.model.PessoaJuridica;
import com.ibm.gestor.repositories.PessoaFisicaRepository;
import com.ibm.gestor.repositories.PessoaJuridicaRepository;
import com.ibm.gestor.repositories.ReceitaRepository;
import com.ibm.gestor.model.Receita;
import jakarta.transaction.Transactional;
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
    PessoaFisicaRepository pessoaFisicaRepository;
    PessoaJuridicaRepository pessoaJuridicaRepository;

    @Transactional
    public Receita save(ReceitaDto receitaDto) {
        Receita receita = Receita.builder()
        .nomeReceita(receitaDto.getNomeReceita())
        .valor(receitaDto.getValor())
        .origemEntrada(receitaDto.getOrigemEntrada())
        .dataEntrada(LocalDateTime.now(ZoneId.of("UTC")))
        .tipoPessoa(receitaDto.getTipoPessoa())
        .build();

        switch (receitaDto.getTipoPessoa()) {
            case FISICA -> {
                PessoaFisica pessoaFisica = pessoaFisicaRepository.findById(receitaDto.getPessoaId())
                                .orElseThrow(() -> new RuntimeException("Pessoa Física não encontrada"));
                receita.setPessoa(pessoaFisica);
            }
            case JURIDICA -> {
                PessoaJuridica pessoaJuridica = pessoaJuridicaRepository.findById(receitaDto.getPessoaId())
                        .orElseThrow(() -> new RuntimeException("Pessoa Jurídica não encontrada"));
                receita.setPessoa(pessoaJuridica);
            }
        }

        return receitaRepository.save(receita);
    }

    public Page<Receita> getAll(Pageable pageable) {
        return receitaRepository.findAll(pageable);
    }

    public Optional<Receita> getById(Long id) {
        return receitaRepository.findById(id);
    }

    @Transactional
    public void delete(Receita receita) {
        receitaRepository.delete(receita);
    }

}
