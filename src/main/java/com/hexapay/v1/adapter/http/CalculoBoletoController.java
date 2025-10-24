package com.hexapay.v1.adapter.http;

import com.hexapay.v1.adapter.http.dto.CalculoBoletoRequest;
import com.hexapay.v1.adapter.http.dto.CalculoBoletoResponse;
import com.hexapay.v1.adapter.http.mapper.CalculoBoletoMapper;
import com.hexapay.v1.core.port.in.CalculoBoletoPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/boleto")
public class CalculoBoletoController {

    private final CalculoBoletoPort calculoBoletoPort;
    private final CalculoBoletoMapper calculoBoletoMapper;

    public CalculoBoletoController(CalculoBoletoPort calculoBoletoPort, CalculoBoletoMapper calculoBoletoMapper) {
        this.calculoBoletoPort = calculoBoletoPort;
        this.calculoBoletoMapper = calculoBoletoMapper;
    }

    @PostMapping("/calculo")
    public ResponseEntity<CalculoBoletoResponse> calcularBoleto(@RequestBody CalculoBoletoRequest request) {
        var boletoCalculado = calculoBoletoPort.executar(request.getCodigo(), request.getDataPagamento());
        var response = calculoBoletoMapper.toResponse(boletoCalculado);
        return ResponseEntity.ok(response);
    }
}
