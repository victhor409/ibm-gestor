package com.ibm.gestor.dtos;


import com.ibm.model.sexo;
import jakarta.validation.constraints.NotBlank;

public class PessoaFisicaDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String endereco;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cpf;
    @NotBlank
    private sexo sexo;

}
