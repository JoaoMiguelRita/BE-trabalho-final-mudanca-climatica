package com.example.trabalho_final.DTO;

public class AtividadeDTO {
    private Long id;
    private String descricao;
    private Double quantidade;
    private Double fatorEmissao;
    private Long categoriaId;

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

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getFatorEmissao() {
        return fatorEmissao;
    }

    public void setFatorEmissao(Double fatorEmissao) {
        this.fatorEmissao = fatorEmissao;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
