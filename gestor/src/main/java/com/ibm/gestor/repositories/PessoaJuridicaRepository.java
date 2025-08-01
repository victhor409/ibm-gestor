package com.ibm.gestor.repositories;

import com.ibm.gestor.model.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

    boolean existsByCnpj(String cnpj);
}
