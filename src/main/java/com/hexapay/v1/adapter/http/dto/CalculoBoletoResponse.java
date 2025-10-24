package com.hexapay.v1.adapter.http.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hexapay.v1.core.domain.enums.TipoBoleto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CalculoBoletoResponse {

    private String codigo;
    @JsonProperty("data_vencimento")
    private LocalDate dataVencimento;
    private BigDecimal valor;
    private TipoBoleto tipo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public TipoBoleto getTipo() {
        return tipo;
    }

    public void setTipo(TipoBoleto tipo) {
        this.tipo = tipo;
    }
}
