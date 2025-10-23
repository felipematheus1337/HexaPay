package com.hexapay.v1.core.domain;

import com.hexapay.v1.core.domain.enums.TipoBoleto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Boleto {

    private String codigo;

    private LocalDate dataVencimento;

    private BigDecimal valor;

    private TipoBoleto tipo;

    public Boleto() {
    }

    public Boleto(String codigo, LocalDate dataVencimento, BigDecimal valor, TipoBoleto tipo) {
        this.codigo = codigo;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoBoleto getTipo() {
        return tipo;
    }

    public void setTipo(TipoBoleto tipo) {
        this.tipo = tipo;
    }
}
