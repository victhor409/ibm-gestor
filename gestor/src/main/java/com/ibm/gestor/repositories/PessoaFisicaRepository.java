package com.ibm.gestor.repositories;

import com.ibm.gestor.model.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

    boolean existsByCpf(String cpf);
}
