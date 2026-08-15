package com.example.Pratica2.service;

import com.example.Pratica2.dto.FuncionarioRequestDTO;
import com.example.Pratica2.dto.FuncionarioResponseDTO;
import com.example.Pratica2.models.FuncionarioModel;
import com.example.Pratica2.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public FuncionarioModel salvarFuncionario(FuncionarioRequestDTO dto) {

        if (repository.findByMatricula(dto.getMatricula()).isPresent()) {
            throw new RuntimeException("Usuário já cadastrado");
        }

        FuncionarioModel novoFuncionario = new FuncionarioModel();

        novoFuncionario.setNome(dto.getNome());
        novoFuncionario.setMatricula(dto.getMatricula());
        novoFuncionario.setCargo(dto.getCargo());

        return repository.save(novoFuncionario);
    }

    public List<FuncionarioResponseDTO> ListarTodos (){
        return repository
                .findAll()
                .stream()
                .map(f -> new FuncionarioResponseDTO(
                        f.getNome(),
                        f.getMatricula(),
                        f.getCargo()
                ))
                .toList();
    }

    public FuncionarioModel AtualizarFuncionario (Long id, FuncionarioModel funcionario) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Funcionário não encontrado!");
        }
        funcionario.setId(id);
        return repository.save(funcionario);
    }

    public void excluir (Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Funcionário não encontrado!");
        }
        repository.deleteById(id);
    }
}