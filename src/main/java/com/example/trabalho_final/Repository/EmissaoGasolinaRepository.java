package com.example.trabalho_final.Repository;


import com.example.trabalho_final.Modelos.EmissaoGasolina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmissaoGasolinaRepository extends JpaRepository<EmissaoGasolina, Long> {
    // JpaRepository já oferece as operações de CRUD padrão
}