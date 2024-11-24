package com.example.trabalho_final.Services;

import com.example.trabalho_final.DTO.CategoriaDTO;
import com.example.trabalho_final.Modelos.Categoria;
import com.example.trabalho_final.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setNome(categoriaDTO.getNome());
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        return mapToDTO(categoriaSalva);
    }

    public List<CategoriaDTO> listarCategorias() {
        return categoriaRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public CategoriaDTO buscarCategoriaPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return mapToDTO(categoria);
    }

    public CategoriaDTO atualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        categoria.setNome(categoriaDTO.getNome());
        Categoria categoriaAtualizada = categoriaRepository.save(categoria);
        return mapToDTO(categoriaAtualizada);
    }

    public void deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    private CategoriaDTO mapToDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        return dto;
    }
}
