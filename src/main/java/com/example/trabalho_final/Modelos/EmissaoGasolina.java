package com.example.trabalho_final.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmissaoGasolina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private double quantidadeEmissao;
    private Long atividadeId;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getQuantidadeEmissao() {
        return quantidadeEmissao;
    }

    public void setQuantidadeEmissao(double quantidadeEmissao) {
        this.quantidadeEmissao = quantidadeEmissao;
    }
}
