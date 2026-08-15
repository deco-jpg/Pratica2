package com.example.Pratica2.dto;

import jakarta.validation.constraints.Size;

public class FuncionarioRequestDTO {

    @Size (message = "Insira o seu nome.")
    private String nome;

    @Size (message = "Insira a sua matricula.")
    private String matricula;

    @Size (message = "Insira o seu cargo.")
    private String cargo;

    public FuncionarioRequestDTO() {
    }

    public FuncionarioRequestDTO(String nome, String matricula, String cargo) {
        this.nome = nome;
        this.matricula = matricula;
        this.cargo = cargo;
    }

    public @Size(message = "Insira o seu nome.") String getNome() {
        return nome;
    }

    public void setNome(@Size(message = "Insira o seu nome.") String nome) {
        this.nome = nome;
    }

    public @Size(message = "Insira a sua matricula.") String getMatricula() {
        return matricula;
    }

    public void setMatricula(@Size(message = "Insira a sua matricula.") String matricula) {
        this.matricula = matricula;
    }

    public @Size(message = "Insira o seu cargo.") String getCargo() {
        return cargo;
    }

    public void setCargo(@Size(message = "Insira o seu cargo.") String cargo) {
        this.cargo = cargo;
    }
}
