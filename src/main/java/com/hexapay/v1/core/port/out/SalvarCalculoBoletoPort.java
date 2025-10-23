package com.hexapay.v1.core.port.out;

import com.hexapay.v1.core.domain.BoletoCalculado;

public interface SalvarCalculoBoletoPort {
    void executar(BoletoCalculado boletoCalculado);
}
