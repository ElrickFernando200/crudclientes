package com.develrick.crudclientes.controllers.handler;

import com.develrick.crudclientes.dtos.ErroCustomizado;
import com.develrick.crudclientes.dtos.ValidationError;
import com.develrick.crudclientes.services.exceptions.RecursoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroCustomizado> validation(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError error = new ValidationError(Instant.now(),status.value(),"Dados Invalidos",request.getRequestURI());
        e.getBindingResult().getFieldErrors().stream().forEach(x -> error.addError(x.getField(),x.getDefaultMessage()));
        return ResponseEntity.status(status).body(error);
    }


}
