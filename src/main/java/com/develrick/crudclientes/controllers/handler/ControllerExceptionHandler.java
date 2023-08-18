package com.develrick.crudclientes.controllers.handler;

import com.develrick.crudclientes.dtos.ErroCustomizado;
import com.develrick.crudclientes.services.exceptions.RecursoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(RecursoException.class)
    public ResponseEntity<ErroCustomizado> recurso(RecursoException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroCustomizado erro = new ErroCustomizado(Instant.now(),status.value(),e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }


}
