package com.example.trabalho_final.Controllers;

import com.example.trabalho_final.DTO.CategoriaDTO;
import com.example.trabalho_final.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaDTO> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Quando criado com sucesso, retornará status 201
    public CategoriaDTO criarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.criarCategoria(categoriaDTO);
    }

    @PutMapping("/{id}")
    public CategoriaDTO atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.atualizarCategoria(id, categoriaDTO);
    }

    @DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
    }
}
