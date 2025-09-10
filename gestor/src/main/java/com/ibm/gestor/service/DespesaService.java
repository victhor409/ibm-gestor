package com.ibm.gestor.service;

import com.ibm.gestor.dtos.DespesaDto;
import com.ibm.gestor.model.Pessoa;
import com.ibm.gestor.repositories.DespesaRepository;
import com.ibm.gestor.model.Despesa;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import static com.ibm.gestor.service.Utils.buscarPessoa;

@Service
public class DespesaService {

    @Autowired
    DespesaRepository despesaRepository;


    @Transactional
    public Despesa save(DespesaDto despesaDto) {

        Pessoa pessoa = buscarPessoa(despesaDto.getTipoPessoa(), despesaDto.getPessoaId());

        Despesa despesa = Despesa.builder()
                .nomeDespesa(despesaDto.getNomeDespesa())
                .valor(despesaDto.getValor())
                .origemEntrada(despesaDto.getOrigemEntrada())
                .dataEntrada(LocalDateTime.now(ZoneId.of("UTC")))
                .tipoPessoa(despesaDto.getTipoPessoa())
                .pessoa(pessoa)
                .build();

        return despesaRepository.save(despesa);
    }

    public Page<Despesa> getAll(Pageable pageable) {
        return despesaRepository.findAll(pageable);
    }

    public Optional<Despesa> getById(Long id) {
        return despesaRepository.findById(id);
    }

    @Transactional
    public void delete(Despesa despesa) {
        despesaRepository.delete(despesa);
    }

    @Transactional
    public Despesa update(Long id, DespesaDto despesaDto) {
        Despesa despesaExistente = despesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Despesa não encontrada"));

        Pessoa pessoa = buscarPessoa(despesaDto.getTipoPessoa(), despesaDto.getPessoaId());

        Despesa despesaAtualizada = despesaExistente.toBuilder()
                .nomeDespesa(despesaDto.getNomeDespesa())
                .valor(despesaDto.getValor())
                .origemEntrada(despesaDto.getOrigemEntrada())
                .tipoPessoa(despesaDto.getTipoPessoa())
                .pessoa(pessoa)
                .build();

        return despesaRepository.save(despesaAtualizada);
    }

}
