package com.develrick.crudclientes.dtos;

public class Error {

    private String nome;
    private String mensagem;

    public Error(String nome, String mensagem){
        this.nome = nome;
        this.mensagem = mensagem;
    }

    public String getNome(){
        return nome;
    }

    public String getMensagem(){
        return mensagem;
    }
}
