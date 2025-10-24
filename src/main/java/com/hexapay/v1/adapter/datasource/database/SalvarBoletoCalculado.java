package com.hexapay.v1.adapter.datasource.database;

import com.hexapay.v1.adapter.datasource.database.repository.BoletoCalculadoRepository;
import com.hexapay.v1.adapter.datasource.mapper.BoletoCalculadoMapper;
import com.hexapay.v1.core.domain.BoletoCalculado;
import com.hexapay.v1.core.port.out.SalvarCalculoBoletoPort;
import org.springframework.stereotype.Service;

@Service
public class SalvarBoletoCalculado implements SalvarCalculoBoletoPort {

    private final BoletoCalculadoRepository repository;
    private final BoletoCalculadoMapper mapper;

    public SalvarBoletoCalculado(BoletoCalculadoRepository repository, BoletoCalculadoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public void executar(BoletoCalculado boletoCalculado) {
        repository.save(mapper.toEntity(boletoCalculado));
    }
}
