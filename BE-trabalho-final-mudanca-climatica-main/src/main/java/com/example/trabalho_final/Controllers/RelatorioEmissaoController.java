package com.example.trabalho_final.Controllers;

import com.example.trabalho_final.DTO.RelatorioEmissaoDTO;
import com.example.trabalho_final.Services.RelatorioEmissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioEmissaoController {

    @Autowired
    private RelatorioEmissaoService relatorioService;

    @PostMapping
    public RelatorioEmissaoDTO criarRelatorio(@RequestBody RelatorioEmissaoDTO relatorioDTO) {
        return relatorioService.criarRelatorio(relatorioDTO);
    }

    @GetMapping
    public List<RelatorioEmissaoDTO> listarRelatorios() {
        return relatorioService.listarRelatorios();
    }
}