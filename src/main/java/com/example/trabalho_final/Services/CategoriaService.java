package com.example.trabalho_final.Services;

import com.example.trabalho_final.DTO.CategoriaDTO;
import com.example.trabalho_final.Modelos.Categoria;
import com.example.trabalho_final.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria criarCategoria(CategoriaDTO categoriaDTO) {
        // Criação da nova categoria
        Categoria categoria = new Categoria();
        categoria.setNome(categoriaDTO.getNome());

        // Salva a categoria no banco de dados
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        Optional<Categoria> categoriaExistente = categoriaRepository.findById(id);
        if (categoriaExistente.isPresent()) {
            Categoria categoria = categoriaExistente.get();
            categoria.setNome(categoriaDTO.getNome());
            return categoriaRepository.save(categoria);
        }
        throw new RuntimeException("Categoria não encontrada");
    }

    public void deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    public Categoria buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }
    public List<CategoriaDTO> listarCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream()
                .map(categoria -> new CategoriaDTO(categoria.getId(), categoria.getNome()))
                .collect(Collectors.toList());
    }

    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }
    public List<Categoria> saveAll(List<Categoria> categorias) {
        return categoriaRepository.saveAll(categorias);
    }
    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public void excluirCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

}
