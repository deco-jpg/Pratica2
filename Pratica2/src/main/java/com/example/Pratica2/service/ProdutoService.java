package com.example.Pratica2.service;


import com.example.Pratica2.dto.ProdutoRequestDTO;
import com.example.Pratica2.dto.ProdutoResponseDTO;
import com.example.Pratica2.models.ProdutoModel;
import com.example.Pratica2.repository.RepositoryProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    public RepositoryProduto repository;

    public ProdutoModel SaveProduto (ProdutoRequestDTO dto) {
        if (repository.findByNome(dto.getNome()).isPresent()) {
            throw new RuntimeException("Produto já cadastrado!");
        }
        ProdutoModel model = new ProdutoModel();
        model.setNome(dto.getNome());
        model.setPreco(dto.getPreco());
        model.setQuant(dto.getQuant());

        return repository.save(model);
    }

    public List<ProdutoResponseDTO>ListAll(){
        return repository.findAll()
                .stream()
                .map(f -> new ProdutoResponseDTO(
                f.getNome(),
                f.getQuant(),
                f.getPreco()
        ))
                .toList();
    }

    public ProdutoModel Update(Long id, ProdutoModel model){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Produto não encontrado!");
        }
        model.setId(id);
        return repository.save(model);
    }

    public void Delet (Long id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Produto não encontrado!");
        }
        repository.deleteById(id);
    }
}
