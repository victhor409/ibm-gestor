package com.ibm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_DESPESAS")
@Getter
@Setter
public class Despesa {
    @Id
    private Long id;
    private String nomeDespesa;
    private BigDecimal valor;
    private String origemEntrada;
    private LocalDateTime dataEntrada;
    private Pessoa pessoa;

}
