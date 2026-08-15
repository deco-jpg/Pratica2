package com.example.Pratica2.dto;

public class ProdutoResponseDTO {

    public String nome;
    public Long quant;
    public Double preco;

    public ProdutoResponseDTO() {
    }

    public ProdutoResponseDTO(String nome, Long quant, Double preco) {
        this.nome = nome;
        this.quant = quant;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQuant() {
        return quant;
    }

    public void setQuant(Long quant) {
        this.quant = quant;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
