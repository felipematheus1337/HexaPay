package com.hexapay.v1.core.domain;

import com.hexapay.v1.core.domain.enums.TipoBoleto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BoletoCalculado {

    private String codigo;
    private BigDecimal valorOriginal;
    private BigDecimal valor;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private BigDecimal juros;
    private TipoBoleto tipo;

    public BoletoCalculado() {
    }

    public BoletoCalculado(String codigo, BigDecimal valorOriginal, BigDecimal valor,
                           LocalDate dataVencimento, LocalDate dataPagamento,
                           BigDecimal juros, TipoBoleto tipo) {
        this.codigo = codigo;
        this.valorOriginal = valorOriginal;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.juros = juros;
        this.tipo = tipo;
    }

    // --- Getters e Setters ---
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(BigDecimal valorOriginal) {
        this.valorOriginal = valorOriginal;
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

    public BigDecimal getJuros() {
        return juros;
    }

    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public TipoBoleto getTipo() {
        return tipo;
    }

    public void setTipo(TipoBoleto tipo) {
        this.tipo = tipo;
    }

    // --- Builder manual ---
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String codigo;
        private BigDecimal valorOriginal;
        private BigDecimal valor;
        private LocalDate dataVencimento;
        private LocalDate dataPagamento;
        private BigDecimal juros;
        private TipoBoleto tipo;

        public Builder codigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder valorOriginal(BigDecimal valorOriginal) {
            this.valorOriginal = valorOriginal;
            return this;
        }

        public Builder valor(BigDecimal valor) {
            this.valor = valor;
            return this;
        }

        public Builder dataVencimento(LocalDate dataVencimento) {
            this.dataVencimento = dataVencimento;
            return this;
        }

        public Builder dataPagamento(LocalDate dataPagamento) {
            this.dataPagamento = dataPagamento;
            return this;
        }

        public Builder juros(BigDecimal juros) {
            this.juros = juros;
            return this;
        }

        public Builder tipo(TipoBoleto tipo) {
            this.tipo = tipo;
            return this;
        }

        public BoletoCalculado build() {
            return new BoletoCalculado(
                    codigo, valorOriginal, valor,
                    dataVencimento, dataPagamento,
                    juros, tipo
            );
        }
    }
}
