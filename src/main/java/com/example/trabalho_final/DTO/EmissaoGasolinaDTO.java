package com.example.trabalho_final.DTO;

import jakarta.validation.constraints.NotNull;

public class EmissaoGasolinaDTO {

    @NotNull
    private String descricao;
    @NotNull
    private double quantidadeEmissao;
    @NotNull
    private Long atividadeId;

    // Getters e Setters

    public double getQuantidadeEmissao() {
        return quantidadeEmissao;
    }

    public void setQuantidadeEmissao(double quantidadeEmissao) {
        this.quantidadeEmissao = quantidadeEmissao;
    }

}
