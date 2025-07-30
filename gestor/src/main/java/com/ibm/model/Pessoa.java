package com.ibm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    private Long Id;
    private String nome;
    @Email(message = "Por favor, forneça um endereço de e-mail válido")
    private String email;
    private String endereco;
    private String telefone;

}
