package com.ibm.gestor.service;

import com.ibm.gestor.repositories.ReceitaRepository;
import com.ibm.model.Receita;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    ReceitaRepository receitaRepository;

    @Transactional
    public Receita save(Receita receita) {
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
