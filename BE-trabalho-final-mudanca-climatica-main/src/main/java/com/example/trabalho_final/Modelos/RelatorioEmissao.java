package com.example.trabalho_final.Modelos;

import jakarta.persistence.*;

@Entity
public class RelatorioEmissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Double emissaoTotal;

    // Construtores
    public RelatorioEmissao() {
    }

    public RelatorioEmissao(String descricao, Double emissaoTotal) {
        this.descricao = descricao;
        this.emissaoTotal = emissaoTotal;
    }

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