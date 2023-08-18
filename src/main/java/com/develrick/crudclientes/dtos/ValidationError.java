package com.develrick.crudclientes.dtos;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends ErroCustomizado{


    private List<Error> erros = new ArrayList<>();
    public ValidationError(Instant timeStamp, Integer status, String error, String path){
        super(timeStamp, status, error, path);
    }


    public void addError(String nome, String mensagem){
        erros.add(new Error(nome,mensagem));
    }

    public List<Error> getErros(){
        return erros;
    }
}
