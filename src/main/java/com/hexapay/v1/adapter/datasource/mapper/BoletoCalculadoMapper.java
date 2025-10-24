package com.hexapay.v1.adapter.datasource.mapper;

import com.hexapay.v1.adapter.datasource.database.entity.BoletoCalculadoEntity;
import com.hexapay.v1.core.domain.BoletoCalculado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoletoCalculadoMapper {

    BoletoCalculadoEntity toEntity(BoletoCalculado boletoCalculado);
}
