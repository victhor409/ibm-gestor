package com.ibm.gestor.dtos;


import jakarta.validation.constraints.NotBlank;

public class PessoaJuridicaDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String endereco;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cnpj;

}
