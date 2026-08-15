package com.example.Pratica2.repository;


import com.example.Pratica2.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryProduto extends JpaRepository<ProdutoModel, Long> {
    Optional<ProdutoModel>findByNome(String nome);
}
