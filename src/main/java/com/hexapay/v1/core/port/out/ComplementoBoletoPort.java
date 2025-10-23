package com.hexapay.v1.core.port.out;

import com.hexapay.v1.core.domain.Boleto;

public interface ComplementoBoletoPort {

    Boleto executar(String codigo);

}
