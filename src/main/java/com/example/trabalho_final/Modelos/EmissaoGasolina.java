package com.example.trabalho_final.Modelos;

public class EmissaoGasolina {
    private double litros;
    private double emissao;

    public EmissaoGasolina(double litros, double emissao){
        this.litros = litros;
        this.emissao = emissao;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public double getEmissao() {
        return emissao;
    }

    public void setEmissao(double emissao) {
        this.emissao = emissao;
    }
}
