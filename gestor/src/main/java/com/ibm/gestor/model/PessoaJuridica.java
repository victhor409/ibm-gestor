package com.ibm.gestor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_PESSOAJURIDICA")
@Getter
@Setter
public class PessoaJuridica extends Pessoa {

    @Column(unique = true)
    @NotBlank
    private String cnpj;

}
