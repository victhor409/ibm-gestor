package com.ibm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_PESSOAFISICA")
@Getter
@Setter
public class PessoaFisica extends Pessoa {

    @Column(unique = true)
    private String cpf;
    private sexo sexo;


}
