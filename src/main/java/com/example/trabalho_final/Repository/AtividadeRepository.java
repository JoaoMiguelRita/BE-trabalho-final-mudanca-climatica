package com.example.trabalho_final.Repository;

import com.example.trabalho_final.Modelos.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
    // JpaRepository já oferece as operações de CRUD padrão, como save(), findById(), deleteById(), etc.
}
