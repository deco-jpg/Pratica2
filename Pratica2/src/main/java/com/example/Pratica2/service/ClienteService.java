package com.example.Pratica2.service;

import com.example.Pratica2.dto.ClienteRequestDTO;
import com.example.Pratica2.dto.ClienteResponseDTO;
import com.example.Pratica2.models.ClienteModel;
import com.example.Pratica2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    //CRUD

    //ADICIONAR - CREATE

    public ClienteModel salvarCliente (ClienteRequestDTO dto) {
        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Cliente já cadastrado.");
        }

        ClienteModel novoCliente = new ClienteModel();
        novoCliente.setNome(dto.getNome());
        novoCliente.setEmail(dto.getEmail());
        novoCliente.setTelefone(dto.getTelefone());

        return repository.save(novoCliente);
    }

    //LISTAR - READ

    public List<ClienteResponseDTO> ListarTodos () {
        return repository
                .findAll()
                .stream()
                .map(c -> new ClienteResponseDTO(
                        c.getNome(),
                        c.getTelefone()
                ))
                .toList();
    }
    //ATUALIZAR - UPDATE

    public ClienteModel atualizarCliente (Long id, ClienteModel cliente) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }

        cliente.setId(id);
        return repository.save(cliente);
    }

    //EXCLUIR - DELETE

    public void excluir (Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
        repository.deleteById(id);
    }

}
