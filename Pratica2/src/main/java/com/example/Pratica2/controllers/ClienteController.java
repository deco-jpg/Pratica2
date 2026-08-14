package com.example.Pratica2.controllers;

import com.example.Pratica2.dto.ClienteRequestDTO;
import com.example.Pratica2.dto.ClienteResponseDTO;
import com.example.Pratica2.models.ClienteModel;
import com.example.Pratica2.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    //LISTAR

    @GetMapping
    public ResponseEntity <List<ClienteResponseDTO>> Listar (){
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(service.ListarTodos());
    }
    //ADD
    @PostMapping
    public  ResponseEntity<Map<String, Object>> Salvar (@Valid @RequestBody ClienteRequestDTO c) {
        service.salvarCliente(c);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Cliente cadastrado com sucesso."));
    }
    //ATUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> AtualizarUsuario(
            @PathVariable Long id,
            @RequestBody ClienteModel cliente) {
        service.atualizarCliente(id,cliente);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Cadastro do Cliente atualizado com sucesso."));
    }
    //DELETAR
    @DeleteMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> DeletarUsuario (@PathVariable Long id) {
        service.excluir(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Cliente deletado com sucesso."));
    }
}

