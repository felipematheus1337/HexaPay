package com.hexapay.v1.adapter.http.exception;

import com.hexapay.v1.core.exception.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Date;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErroResponse> applicationException(ApplicationException ex, WebRequest request) {
        var response = new ErroResponse();

        response.setMensagens(Arrays.asList(ex.getTipoExcecao().getMensagemErro()));
        response.setCodigo(HttpStatus.BAD_REQUEST.value());
        response.setErro(ex.getTipoExcecao().toString().toLowerCase());
        response.setTimestamp(new Date());
        response.setPath(request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
