package com.example.trabalho_final.Services;

import com.example.trabalho_final.Modelos.EmissaoGasolina;
import org.springframework.stereotype.Service;

@Service
public class EmissaoGasolinaService {
    private final double fator_1 = 0.82;
    private final double fator_2 = 0.75;
    private final double fator_3 = 3.7;

    public EmissaoGasolina calcularEmissaoC02(double litros){
        double emissao = litros * fator_1 * fator_2 * fator_3;
        System.out.println("Litros: " + litros + ", Emissão Calculada: " + emissao); // Log para depuração
        return new EmissaoGasolina(litros, emissao);
    }
}
