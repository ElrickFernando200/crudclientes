package com.develrick.crudclientes.dtos;

import com.develrick.crudclientes.entities.Cliente;

import java.time.LocalDate;

public class ClienteDTO {


    private Long id;
    private String nome;
    private String cpf;
    private Double renda;
    private LocalDate dataNascimento;
    private Integer quantidadeFilhos;


    public ClienteDTO(){}

    public ClienteDTO(Long id, String nome, String cpf, Double renda, LocalDate dataNascimento, Integer quantidadeFilhos){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.renda = renda;
        this.dataNascimento = dataNascimento;
        this.quantidadeFilhos = quantidadeFilhos;
    }


    public ClienteDTO(Cliente entidade){
        id = entidade.getId();
        nome = entidade.getNome();
        cpf = entidade.getCpf();
        renda = entidade.getRenda();
        dataNascimento = entidade.getDataNascimento();
        quantidadeFilhos = entidade.getQuantidadeFilhos();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getRenda() {
        return renda;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Integer getQuantidadeFilhos() {
        return quantidadeFilhos;
    }
}
