package com.ibm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_PESSOAJURIDICA")
@Getter
@Setter
public class PessoaJuridica extends Pessoa {

    private String cnpj;

}
