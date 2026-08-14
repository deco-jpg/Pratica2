package com.example.Pratica2.dto;

public class ClienteResponseDTO {

    private String nome;
    private String telefone;

    public ClienteResponseDTO() {
    }

    public ClienteResponseDTO(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
