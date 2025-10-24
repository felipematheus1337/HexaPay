package com.hexapay.v1.adapter.datasource.mapper;

import com.hexapay.v1.adapter.datasource.integration.dto.BoletoDTO;
import com.hexapay.v1.core.domain.Boleto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoletoMapper {

    Boleto toDomain(BoletoDTO boletoDTO);

}
