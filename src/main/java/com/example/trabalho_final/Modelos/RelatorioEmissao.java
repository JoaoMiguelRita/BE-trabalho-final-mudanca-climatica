package com.example.trabalho_final.Modelos;

import jakarta.persistence.*;

@Entity
public class RelatorioEmissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeRelatorio;
    private double emissaoTotal;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public double getEmissaoTotal() {
        return emissaoTotal;
    }

    public void setEmissaoTotal(double emissaoTotal) {
        this.emissaoTotal = emissaoTotal;
    }
}