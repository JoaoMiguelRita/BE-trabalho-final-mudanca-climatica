package com.example.trabalho_final.Services;

import com.example.trabalho_final.DTO.EmissaoGasolinaDTO;
import com.example.trabalho_final.Modelos.EmissaoGasolina;
import com.example.trabalho_final.Repository.EmissaoGasolinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmissaoGasolinaService {

    @Autowired
    private EmissaoGasolinaRepository emissaoGasolinaRepository;

    public EmissaoGasolina criarEmissaoGasolina(EmissaoGasolinaDTO emissaoGasolinaDTO) {
        EmissaoGasolina emissao = new EmissaoGasolina();
        emissao.setQuantidadeEmissao(emissaoGasolinaDTO.getQuantidadeEmissao());
        return emissaoGasolinaRepository.save(emissao);
    }

    public EmissaoGasolina atualizarEmissaoGasolina(Long id, EmissaoGasolinaDTO emissaoGasolinaDTO) {
        Optional<EmissaoGasolina> emissaoExistente = emissaoGasolinaRepository.findById(id);
        if (emissaoExistente.isPresent()) {
            EmissaoGasolina emissao = emissaoExistente.get();
            emissao.setQuantidadeEmissao(emissaoGasolinaDTO.getQuantidadeEmissao());
            return emissaoGasolinaRepository.save(emissao);
        }
        throw new RuntimeException("Emissão de gasolina não encontrada");
    }

    public boolean excluirEmissao(Long id) {
        if (emissaoGasolinaRepository.existsById(id)) {
            emissaoGasolinaRepository.deleteById(id);
            return true; // Exclusão realizada com sucesso
        }
        return false; // Emissão não encontrada ou já foi excluída
    }

    public EmissaoGasolina buscarEmissaoGasolinaPorId(Long id) {
        return emissaoGasolinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emissão de gasolina não encontrada"));
    }
    public List<EmissaoGasolina> buscarTodas() {
        return emissaoGasolinaRepository.findAll();
    }
}
