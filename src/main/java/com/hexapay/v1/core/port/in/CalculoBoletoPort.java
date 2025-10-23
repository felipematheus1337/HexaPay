package com.hexapay.v1.core.port.in;

import com.hexapay.v1.core.domain.BoletoCalculado;

import java.time.LocalDate;

public interface CalculoBoletoPort {
    BoletoCalculado executar(String codigo, LocalDate dataPagamento);
}
