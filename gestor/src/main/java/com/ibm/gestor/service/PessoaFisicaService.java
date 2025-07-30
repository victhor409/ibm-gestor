package com.ibm.gestor.service;

import com.ibm.gestor.repositories.PessoaFisicaRepository;
import com.ibm.model.PessoaFisica;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaFisicaService {

    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;

    @Transactional
    public PessoaFisica save(PessoaFisica pessoaFisica) {
        return pessoaFisicaRepository.save(pessoaFisica);
    }

    public Page<PessoaFisica> getAll(Pageable pageable) {
        return pessoaFisicaRepository.findAll(pageable);
    }

    public Optional<PessoaFisica> getById(Long id) {
        return pessoaFisicaRepository.findById(id);
    }

    public void delete(PessoaFisica pessoaFisica) {
        pessoaFisicaRepository.delete(pessoaFisica);
    }

    public boolean existsByCpf(String cpf) {
        return pessoaFisicaRepository.existsByCpf(cpf);
    }

}
