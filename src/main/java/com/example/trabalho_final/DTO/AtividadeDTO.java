package com.example.trabalho_final.DTO;

import jakarta.validation.constraints.NotNull;

public class AtividadeDTO {

    private String nome;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
