package com.example.trabalho_final.Controllers;

import com.example.trabalho_final.DTO.RelatorioEmissaoDTO;
import com.example.trabalho_final.Modelos.RelatorioEmissao;
import com.example.trabalho_final.Services.RelatorioEmissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios/emissao")
public class RelatorioEmissaoController {

    @Autowired
    private RelatorioEmissaoService relatorioEmissaoService;

    // Criar um novo relatório de emissão
    @PostMapping
    public ResponseEntity<RelatorioEmissao> criarRelatorioEmissao(@RequestBody RelatorioEmissaoDTO relatorioEmissaoDTO) {
        RelatorioEmissao relatorioEmissao = relatorioEmissaoService.criarRelatorioEmissao(relatorioEmissaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(relatorioEmissao);
    }

    // Atualizar um relatório de emissão existente
    @PutMapping("/{id}")
    public ResponseEntity<RelatorioEmissao> atualizarRelatorioEmissao(@PathVariable Long id, @RequestBody RelatorioEmissaoDTO relatorioEmissaoDTO) {
        RelatorioEmissao relatorioEmissao = relatorioEmissaoService.atualizarRelatorioEmissao(id, relatorioEmissaoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(relatorioEmissao);
    }

    // Deletar um relatório de emissão
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirRelatorioPorId(@PathVariable Long id) {
        try {
            relatorioEmissaoService.excluirRelatorioPorId(id);
            return ResponseEntity.ok("Relatório de Emissão excluído com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("Relatório de Emissão não encontrado ou já foi excluído!");
        }
    }

    // Buscar um relatório de emissão por ID
    @GetMapping("/{id}")
    public ResponseEntity<RelatorioEmissao> buscarRelatorioEmissaoPorId(@PathVariable Long id) {
        RelatorioEmissao relatorioEmissao = relatorioEmissaoService.buscarRelatorioEmissaoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(relatorioEmissao);
    }
    @GetMapping
    public ResponseEntity<List<RelatorioEmissao>> buscarTodosRelatorios() {
        List<RelatorioEmissao> relatorios = relatorioEmissaoService.buscarTodosRelatorios();
        return ResponseEntity.ok(relatorios);
    }
}