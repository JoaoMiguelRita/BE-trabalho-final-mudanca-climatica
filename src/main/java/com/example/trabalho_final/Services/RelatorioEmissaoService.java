package com.example.trabalho_final.Services;

import com.example.trabalho_final.DTO.RelatorioEmissaoDTO;
import com.example.trabalho_final.Modelos.RelatorioEmissao;
import com.example.trabalho_final.Repository.RelatorioEmissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelatorioEmissaoService {

    @Autowired
    private RelatorioEmissaoRepository relatorioEmissaoRepository;

    public RelatorioEmissaoDTO criarRelatorio(RelatorioEmissaoDTO relatorioDTO) {
        RelatorioEmissao relatorio = new RelatorioEmissao();
        relatorio.setDescricao(relatorioDTO.getDescricao());
        relatorio.setEmissaoTotal(relatorioDTO.getEmissaoTotal());
        RelatorioEmissao relatorioSalvo = relatorioEmissaoRepository.save(relatorio);
        return mapToDTO(relatorioSalvo);
    }

    public List<RelatorioEmissaoDTO> listarRelatorios() {
        return relatorioEmissaoRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public RelatorioEmissaoDTO buscarRelatorioPorId(Long id) {
        RelatorioEmissao relatorio = relatorioEmissaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relatório não encontrado"));
        return mapToDTO(relatorio);
    }

    private RelatorioEmissaoDTO mapToDTO(RelatorioEmissao relatorio) {
        RelatorioEmissaoDTO dto = new RelatorioEmissaoDTO();
        dto.setId(relatorio.getId());
        dto.setDescricao(relatorio.getDescricao());
        dto.setEmissaoTotal(relatorio.getEmissaoTotal());
        return dto;
    }
}