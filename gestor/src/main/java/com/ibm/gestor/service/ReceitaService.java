package com.ibm.gestor.service;

import com.ibm.gestor.dtos.ReceitaDto;
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
        Receita receita = new Receita();
        receita.setNomeReceita(receitaDto.getNomeReceita());
        receita.setValor(receitaDto.getValor());
        receita.setOrigemEntrada(receitaDto.getOrigemEntrada());
        receita.setDataEntrada(LocalDateTime.now(ZoneId.of("UTC")));
        receita.setTipoPessoa(receitaDto.getTipoPessoa());

        switch (receitaDto.getTipoPessoa()) {
            case FISICA -> {
                receita.setPessoa(pessoaFisicaRepository.findById(receitaDto.getPessoaId()).get());
            }
            case JURIDICA -> {
                receita.setPessoa(pessoaJuridicaRepository.findById(receitaDto.getPessoaId()).get());
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
