package com.example.trabalho_final.Controllers;

import com.example.trabalho_final.DTO.AtividadeDTO;
import com.example.trabalho_final.Modelos.Atividade;
import com.example.trabalho_final.Services.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @PostMapping
    public ResponseEntity<Atividade> criarAtividade(@RequestBody AtividadeDTO atividadeDTO) {
        Atividade novaAtividade = atividadeService.criarAtividade(atividadeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAtividade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atividade> atualizarAtividade(@PathVariable Long id, @RequestBody AtividadeDTO atividadeDTO) {
        Atividade atividade = atividadeService.atualizarAtividade(id, atividadeDTO);
        return ResponseEntity.status(HttpStatus.OK).body(atividade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirAtividade(@PathVariable Long id) {
        boolean foiExcluida = atividadeService.excluirAtividade(id);
        if (foiExcluida) {
            return ResponseEntity.status(HttpStatus.OK).body("Atividade excluída com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atividade não encontrada ou já foi excluída!");
        }
    }

    @GetMapping({"/", "/{id}"})
    public ResponseEntity<?> buscarAtividade(@PathVariable(required = false) Long id) {
        if (id == null) {
            List<Atividade> atividades = atividadeService.buscarTodasAtividades();
            return ResponseEntity.status(HttpStatus.OK).body(atividades);
        } else {
            Atividade atividade = atividadeService.buscarAtividadePorId(id);
            if (atividade != null) {
                return ResponseEntity.status(HttpStatus.OK).body(atividade);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atividade não encontrada");
            }
        }
    }
}