package com.hexapay.v1.adapter.datasource.integration;

import com.hexapay.v1.adapter.datasource.integration.client.ComplementoBoletoClient;
import com.hexapay.v1.adapter.datasource.mapper.BoletoMapper;
import com.hexapay.v1.core.domain.Boleto;
import com.hexapay.v1.core.port.out.ComplementoBoletoPort;
import org.springframework.stereotype.Service;

@Service
public class ComplementoBoletoIntegration implements ComplementoBoletoPort {

    private final ComplementoBoletoClient complementoBoletoClient;
    private final BoletoMapper mapper;

    public ComplementoBoletoIntegration(ComplementoBoletoClient complementoBoletoClient, BoletoMapper mapper) {
        this.complementoBoletoClient = complementoBoletoClient;
        this.mapper = mapper;
    }

    @Override
    public Boleto executar(String codigo) {
        var boletoDTO = complementoBoletoClient.getBoleto(codigo);
        return mapper.toDomain(boletoDTO);
    }
}
