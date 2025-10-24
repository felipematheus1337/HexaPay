package com.hexapay.v1.adapter.http.mapper;

import com.hexapay.v1.adapter.http.dto.CalculoBoletoResponse;
import com.hexapay.v1.core.domain.BoletoCalculado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CalculoBoletoMapper {

    CalculoBoletoResponse toResponse(BoletoCalculado boletoCalculado);
}
