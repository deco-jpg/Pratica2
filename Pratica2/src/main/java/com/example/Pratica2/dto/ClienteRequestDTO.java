package com.example.Pratica2.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class ClienteRequestDTO {

    @Size (message = "Por favor, o nooomeeee!")
    private String nome;

    @Size (message = "Por favorr, seu emaiilll!")
    @Email (message = "Coloque um email válido")
    private String email;

    @Size (message = "Digite seu telefone")
    private String telefone;

    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public @Size(message = "Por favor, o nooomeeee!") String getNome() {
        return nome;
    }

    public void setNome(@Size(message = "Por favor, o nooomeeee!") String nome) {
        this.nome = nome;
    }

    public @Size(message = "Por favorr, seu emaiilll!") @Email(message = "Coloque um email válido") String getEmail() {
        return email;
    }

    public void setEmail(@Size(message = "Por favorr, seu emaiilll!") @Email(message = "Coloque um email válido") String email) {
        this.email = email;
    }

    public @Size(message = "Digite seu telefone") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@Size(message = "Digite seu telefone") String telefone) {
        this.telefone = telefone;
    }
}
