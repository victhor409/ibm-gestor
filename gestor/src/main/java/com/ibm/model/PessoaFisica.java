package com.ibm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_PESSOAFISICA")
@Getter
@Setter
public class PessoaFisica extends Pessoa {

    private String cpf;

}
