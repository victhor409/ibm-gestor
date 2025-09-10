package com.ibm.gestor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Por favor, forneça um nome válido")
    private String nome;
    @Email(message = "Por favor, forneça um endereço de e-mail válido")
    @NotBlank
    private String email;
    @NotBlank(message = "Por favor, forneça um endereço válido")
    private String endereco;
    @NotBlank(message = "Por favor, forneça um telefone válido")
    private String telefone;

}
