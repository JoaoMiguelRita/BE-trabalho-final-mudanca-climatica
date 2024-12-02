package com.example.trabalho_final.DTO;

import jakarta.validation.constraints.NotNull;

public class RelatorioEmissaoDTO {

    @NotNull
    private String nomeRelatorio;
    private double emissaoTotal;

    // Getters e Setters

    public double getEmissaoTotal() {
        return emissaoTotal;
    }

    public void setEmissaoTotal(double emissaoTotal) {
        this.emissaoTotal = emissaoTotal;
    }
}
