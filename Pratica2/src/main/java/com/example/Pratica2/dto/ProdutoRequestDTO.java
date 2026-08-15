package com.example.Pratica2.dto;

import jakarta.validation.constraints.NotBlank;

public class ProdutoRequestDTO {

    @NotBlank(message = "Digite o nome do produto.")
    private String nome;

    @NotBlank (message = "Digite o preço do produto.")
    private Double preco;

    @NotBlank(message = "Digite a quantidade dos produtos.")
    private Long quant;

    public ProdutoRequestDTO() {
    }

    public ProdutoRequestDTO(String nome, Double preco, Long quant) {
        this.nome = nome;
        this.preco = preco;
        this.quant = quant;
    }

    public @NotBlank(message = "Digite o nome do produto.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Digite o nome do produto.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Digite o preço do produto.") Double getPreco() {
        return preco;
    }

    public void setPreco(@NotBlank(message = "Digite o preço do produto.") Double preco) {
        this.preco = preco;
    }

    public @NotBlank(message = "Digite a quantidade dos produtos.") Long getQuant() {
        return quant;
    }

    public void setQuant(@NotBlank(message = "Digite a quantidade dos produtos.") Long quant) {
        this.quant = quant;
    }
}
