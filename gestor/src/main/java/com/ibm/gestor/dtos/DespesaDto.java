package com.ibm.gestor.dtos;

import com.ibm.model.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DespesaDto {

    @NotBlank
    private String nomeDespesa;
    @NotNull
    private BigDecimal valor;
    @NotBlank
    private String origemEntrada;
}
