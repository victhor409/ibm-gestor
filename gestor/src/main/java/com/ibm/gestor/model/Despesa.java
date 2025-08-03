package com.ibm.gestor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Pessoa_id")
    private Pessoa pessoa;

}
