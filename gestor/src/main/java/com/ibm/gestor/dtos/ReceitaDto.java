package com.ibm.gestor.dtos;

import com.ibm.model.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ReceitaDto {

    @NotBlank
    private String nomeReceita;
    @NotNull
    private BigDecimal valor;
    @NotBlank
    private String origemEntrada;
    private Pessoa pessoa;
}
