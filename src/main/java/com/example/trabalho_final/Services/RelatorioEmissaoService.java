package com.example.trabalho_final.Services;

import com.example.trabalho_final.DTO.RelatorioEmissaoDTO;
import com.example.trabalho_final.Modelos.RelatorioEmissao;
import com.example.trabalho_final.Repository.RelatorioEmissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelatorioEmissaoService {

    @Autowired
    private RelatorioEmissaoRepository relatorioEmissaoRepository;

    // Criar um novo relatório de emissão
    public RelatorioEmissao criarRelatorioEmissao(RelatorioEmissaoDTO relatorioEmissaoDTO) {
        RelatorioEmissao relatorioEmissao = new RelatorioEmissao();
        relatorioEmissao.setEmissaoTotal(relatorioEmissaoDTO.getEmissaoTotal());
        return relatorioEmissaoRepository.save(relatorioEmissao);
    }

    // Atualizar um relatório de emissão existente
    public RelatorioEmissao atualizarRelatorioEmissao(Long id, RelatorioEmissaoDTO relatorioEmissaoDTO) {
        Optional<RelatorioEmissao> relatorioEmissaoExistente = relatorioEmissaoRepository.findById(id);
        if (relatorioEmissaoExistente.isPresent()) {
            RelatorioEmissao relatorioEmissao = relatorioEmissaoExistente.get();
            relatorioEmissao.setEmissaoTotal(relatorioEmissaoDTO.getEmissaoTotal());
            return relatorioEmissaoRepository.save(relatorioEmissao);
        }
        throw new RuntimeException("Relatório de emissão não encontrado");
    }

    // Deletar um relatório de emissão
    public void excluirRelatorioPorId(Long id) {
        if (!relatorioEmissaoRepository.existsById(id)) {
            throw new IllegalArgumentException("Relatório de Emissão não encontrado ou já foi excluído!");
        }
        relatorioEmissaoRepository.deleteById(id);
    }

    // Buscar um relatório de emissão por ID
    public RelatorioEmissao buscarRelatorioEmissaoPorId(Long id) {
        return relatorioEmissaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relatório de emissão não encontrado"));
    }
    public List<RelatorioEmissao> buscarTodosRelatorios() {
        return relatorioEmissaoRepository.findAll();
    }
}