package com.exemplo.manutencao.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Entity
@Table(name = "itens_servico")
@JsonInclude(JsonInclude.Include.NON_NULL) // Sumirá com qualquer campo nulo do JSON
public class ItemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String descricao;
    public Double valorTotal;

    public ItemServico() {}
    public ItemServico(String descricao, Double valorTotal) {
        this.descricao = descricao;
        this.valorTotal = valorTotal;
    }
}
