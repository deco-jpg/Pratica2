package com.example.Pratica2.controllers;


import com.example.Pratica2.dto.ProdutoRequestDTO;
import com.example.Pratica2.dto.ProdutoResponseDTO;
import com.example.Pratica2.models.ProdutoModel;
import com.example.Pratica2.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;
    //LISTAR
    @GetMapping
    public ResponseEntity <List<ProdutoResponseDTO>> Listar (){
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(service.ListAll());
    }
    //ADD
    @PostMapping
    public  ResponseEntity<Map<String, Object>> Salvar (@Valid @RequestBody ProdutoRequestDTO u) {
        service.SaveProduto(u);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Produto cadastrado com sucesso."));
    }
    //ATUALIZAR
    @PutMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> AtualizarProduto(
            @PathVariable Long id,
            @RequestBody ProdutoModel produto) {
        service.Update(id,produto);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Cadastro do produto atualizado com sucesso."));
    }
    //DELETAR
    @DeleteMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> DeletarProduto (@PathVariable Long id) {
        service.Delet(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Produto deletado com sucesso."));
    }
}
