package com.example.trabalho_final.Services;

import com.example.trabalho_final.DTO.AtividadeDTO;
import com.example.trabalho_final.Modelos.Atividade;
import com.example.trabalho_final.Modelos.Categoria;
import com.example.trabalho_final.Repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public Atividade criarAtividade(AtividadeDTO atividadeDTO) {
        Atividade atividade = new Atividade();
        atividade.setNome(atividadeDTO.getNome());

        // Salvar no banco de dados
        return atividadeRepository.save(atividade);
    }
    public Atividade atualizarAtividade(Long id, AtividadeDTO atividadeDTO) {
        // Buscar a atividade existente no banco
        Atividade atividadeExistente = atividadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atividade não encontrada"));

        // Atualizar os dados da atividade
        atividadeExistente.setNome(atividadeDTO.getNome());

        // Salvar as alterações
        return atividadeRepository.save(atividadeExistente);
    }
    public boolean excluirAtividade(Long id) {
        if (atividadeRepository.existsById(id)) {
            atividadeRepository.deleteById(id);
            return true; // Atividade excluída com sucesso
        }
        return false; // Atividade não encontrada ou já foi excluída
    }

    public Atividade buscarAtividadePorId(Long id) {
        return atividadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atividade não encontrada"));
    }
    public List<Atividade> buscarTodasAtividades() {
        return atividadeRepository.findAll();
    }
}
