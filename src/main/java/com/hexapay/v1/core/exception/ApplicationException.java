package com.hexapay.v1.core.exception;

import com.hexapay.v1.core.domain.enums.TipoExcecao;


public class ApplicationException extends RuntimeException {
    private TipoExcecao tipoExcecao;


    public TipoExcecao getTipoExcecao() {
        return tipoExcecao;
    }

    public ApplicationException(TipoExcecao tipoExcecao) {
        super(tipoExcecao.getMensagemErro());
        this.tipoExcecao = tipoExcecao;
    }
}
