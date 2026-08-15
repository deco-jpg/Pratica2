package com.example.Pratica2.models;


import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "tab_produtos")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Long quant;

    @Column(nullable = false)
    private Double preco;

    public ProdutoModel() {
    }

    public ProdutoModel(Long id, String nome, Long quant, Double preco) {
        this.id = id;
        this.nome = nome;
        this.quant = quant;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getQuant() {
        return quant;
    }

    public Double getPreco() {
        return preco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuant(Long quant) {
        this.quant = quant;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}


