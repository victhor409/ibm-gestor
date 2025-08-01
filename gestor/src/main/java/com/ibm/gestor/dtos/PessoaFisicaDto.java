package com.ibm.gestor.dtos;


import com.ibm.gestor.model.sexo;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
