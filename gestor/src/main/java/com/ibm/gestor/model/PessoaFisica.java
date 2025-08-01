package com.ibm.gestor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_PESSOAFISICA")
@Getter
@Setter
public class PessoaFisica extends Pessoa {

    @Column(unique = true)
    private String cpf;
    @Enumerated(EnumType.STRING)
    private sexo sexo;

}
