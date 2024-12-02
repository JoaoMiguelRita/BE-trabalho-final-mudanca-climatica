package com.example.trabalho_final.Controllers;

import com.example.trabalho_final.DTO.EmissaoGasolinaDTO;
import com.example.trabalho_final.Modelos.EmissaoGasolina;
import com.example.trabalho_final.Services.EmissaoGasolinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emissoes/gasolina")
public class EmissaoGasolinaController {

    @Autowired
    private EmissaoGasolinaService emissaoGasolinaService;

    @PostMapping
    public ResponseEntity<EmissaoGasolina> criarEmissaoGasolina(@RequestBody EmissaoGasolinaDTO emissaoGasolinaDTO) {
        EmissaoGasolina emissao = emissaoGasolinaService.criarEmissaoGasolina(emissaoGasolinaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(emissao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmissaoGasolina> atualizarEmissaoGasolina(@PathVariable Long id, @RequestBody EmissaoGasolinaDTO emissaoGasolinaDTO) {
        EmissaoGasolina emissao = emissaoGasolinaService.atualizarEmissaoGasolina(id, emissaoGasolinaDTO);
        return ResponseEntity.status(HttpStatus.OK).body(emissao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirEmissao(@PathVariable Long id) {
        boolean foiExcluida = emissaoGasolinaService.excluirEmissao(id);
        if (foiExcluida) {
            return ResponseEntity.ok("Emissão excluída com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emissão não encontrada ou já foi excluída!");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmissaoGasolina> buscarEmissaoGasolinaPorId(@PathVariable Long id) {
        EmissaoGasolina emissao = emissaoGasolinaService.buscarEmissaoGasolinaPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(emissao);
    }
    @GetMapping
    public ResponseEntity<List<EmissaoGasolina>> buscarTodasEmissoes() {
        List<EmissaoGasolina> todasEmissoes = emissaoGasolinaService.buscarTodas();
        return ResponseEntity.ok(todasEmissoes);
    }
}
