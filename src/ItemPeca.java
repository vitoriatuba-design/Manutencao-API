package com.exemplo.manutencao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "itens_peca")
public class ItemPeca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public Double preco;
    public Integer quantidade;

    public ItemPeca() {}
    public ItemPeca(String nome, Double preco, Integer quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
}
