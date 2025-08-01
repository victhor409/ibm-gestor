package com.ibm.gestor.service;

import com.ibm.gestor.repositories.DespesaRepository;
import com.ibm.gestor.model.Despesa;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DespesaService {

    @Autowired
    DespesaRepository despesaRepository;

    @Transactional
    public Despesa save(Despesa despesa) {
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

}
