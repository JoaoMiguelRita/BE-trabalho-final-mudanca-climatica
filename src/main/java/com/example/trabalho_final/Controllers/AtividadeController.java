package com.example.trabalho_final.Controllers;

import com.example.trabalho_final.DTO.AtividadeDTO;
import com.example.trabalho_final.Services.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @PostMapping("/{categoriaId}")
    public AtividadeDTO criarAtividade(@PathVariable Long categoriaId, @RequestBody AtividadeDTO atividadeDTO) {
        return atividadeService.criarAtividade(categoriaId, atividadeDTO);
    }

    @GetMapping
    public List<AtividadeDTO> listarAtividades() {
        return atividadeService.listarAtividades();
    }
}