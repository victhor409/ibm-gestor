package com.ibm.gestor.dtos;

import com.ibm.gestor.model.tipoPessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ReceitaDto {

    @NotBlank
    private String nomeReceita;
    @NotNull
    private BigDecimal valor;
    @NotBlank
    private String origemEntrada;
    @NotBlank
    private tipoPessoa tipoPessoa;
    @NotBlank
    private Long pessoaId;
}
