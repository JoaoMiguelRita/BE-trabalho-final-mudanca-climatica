package com.example.trabalho_final.DTO;

public class RelatorioEmissaoDTO {
    private Long id;
    private String descricao;
    private Double emissaoTotal;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getEmissaoTotal() {
        return emissaoTotal;
    }

    public void setEmissaoTotal(Double emissaoTotal) {
        this.emissaoTotal = emissaoTotal;
    }
}