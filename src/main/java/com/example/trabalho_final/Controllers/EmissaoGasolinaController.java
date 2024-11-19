package com.example.trabalho_final.Controllers;

import com.example.trabalho_final.DPO.EmissaoGasolinaDTO;
import com.example.trabalho_final.Modelos.EmissaoGasolina;
import com.example.trabalho_final.Services.EmissaoGasolinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emissoes")
public class EmissaoGasolinaController {

    @Autowired
    private EmissaoGasolinaService emissaoGasolinaService;

    @PostMapping("/co2")
    public ResponseEntity<EmissaoGasolina> calcularEmissaoCO2(@RequestBody EmissaoGasolinaDTO dto){
        EmissaoGasolina resultado = emissaoGasolinaService.calcularEmissaoC02(dto.getLitros());
        return ResponseEntity.ok(resultado);
    }
}
