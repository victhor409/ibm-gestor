package com.ibm.gestor.service;

import com.ibm.gestor.repositories.PessoaJuridicaRepository;
import com.ibm.model.PessoaJuridica;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaJuridicaService {

    @Autowired
    PessoaJuridicaRepository pessoaJuridicaRepository;

    @Transactional
    public PessoaJuridica save(PessoaJuridica pessoaJuridica) {
        return pessoaJuridicaRepository.save(pessoaJuridica);
    }

    public Page<PessoaJuridica> getAll(Pageable pageable) {
        return pessoaJuridicaRepository.findAll(pageable);
    }

    public Optional<PessoaJuridica> getById(Long id) {
        return pessoaJuridicaRepository.findById(id);
    }

    public void delete(PessoaJuridica pessoaJuridica) {
        pessoaJuridicaRepository.delete(pessoaJuridica);
    }

    public boolean existsByCnpj(String cnpj) {
        return pessoaJuridicaRepository.existsByCnpj(cnpj);
    }

}
