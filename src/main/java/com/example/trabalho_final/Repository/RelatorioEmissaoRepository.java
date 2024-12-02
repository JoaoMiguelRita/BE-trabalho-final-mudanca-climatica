package com.example.trabalho_final.Repository;

import com.example.trabalho_final.Modelos.RelatorioEmissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioEmissaoRepository extends JpaRepository<RelatorioEmissao, Long> {
    // JpaRepository já oferece as operações de CRUD padrão, como save(), findById(), deleteById(), etc.
}
