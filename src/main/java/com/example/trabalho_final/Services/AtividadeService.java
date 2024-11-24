package com.example.trabalho_final.Services;

import com.example.trabalho_final.DTO.AtividadeDTO;
import com.example.trabalho_final.Modelos.Atividade;
import com.example.trabalho_final.Modelos.Categoria;
import com.example.trabalho_final.Repository.AtividadeRepository;
import com.example.trabalho_final.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public AtividadeDTO criarAtividade(Long categoriaId, AtividadeDTO atividadeDTO) {
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Atividade atividade = new Atividade();
        atividade.setDescricao(atividadeDTO.getDescricao());
        atividade.setQuantidade(atividadeDTO.getQuantidade());
        atividade.setFatorEmissao(atividadeDTO.getFatorEmissao());
        atividade.setCategoria(categoria);

        Atividade atividadeSalva = atividadeRepository.save(atividade);
        return mapToDTO(atividadeSalva);
    }

    public List<AtividadeDTO> listarAtividades() {
        return atividadeRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public AtividadeDTO buscarAtividadePorId(Long id) {
        Atividade atividade = atividadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atividade não encontrada"));
        return mapToDTO(atividade);
    }

    public void deletarAtividade(Long id) {
        atividadeRepository.deleteById(id);
    }

    private AtividadeDTO mapToDTO(Atividade atividade) {
        AtividadeDTO dto = new AtividadeDTO();
        dto.setId(atividade.getId());
        dto.setDescricao(atividade.getDescricao());
        dto.setQuantidade(atividade.getQuantidade());
        dto.setFatorEmissao(atividade.getFatorEmissao());
        dto.setCategoriaId(atividade.getCategoria().getId());
        return dto;
    }
}
