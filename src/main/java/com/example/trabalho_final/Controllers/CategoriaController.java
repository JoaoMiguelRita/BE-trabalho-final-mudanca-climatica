package com.example.trabalho_final.Controllers;

import com.example.trabalho_final.DTO.CategoriaDTO;
import com.example.trabalho_final.Modelos.Categoria;
import com.example.trabalho_final.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria novaCategoria = categoriaService.criarCategoria(categoriaDTO);
        return ResponseEntity.status(201).body(novaCategoria);
    }
    @PostMapping("/multi")
    public ResponseEntity<List<Categoria>> createMultipleCategorias(@RequestBody List<Categoria> categorias) {
        List<Categoria> categoriasSalvas = categoriaService.saveAll(categorias);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriasSalvas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaService.atualizarCategoria(id, categoriaDTO);
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
        List<CategoriaDTO> categorias = categoriaService.listarCategorias();
        return ResponseEntity.ok(categorias);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCategoria(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.buscarPorId(id);

        if (categoria.isPresent()) {
            categoriaService.excluirCategoria(id);
            return ResponseEntity.ok("Categoria excluída com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Categoria não encontrada ou já foi excluída!");
        }
    }
}
