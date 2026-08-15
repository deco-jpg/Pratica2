package com.example.Pratica2.repository;

import com.example.Pratica2.models.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository <FuncionarioModel, Long> {
    Optional <FuncionarioModel> findByMatricula (String matricula);
}
