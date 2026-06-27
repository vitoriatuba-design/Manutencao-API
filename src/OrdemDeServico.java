package com.exemplo.manutencao.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordens_servico")
public class OrdemDeServico extends ItemServico {

    // REMOVIDO: public Long id; (Evita duplicar e anular o ID herdado de ItemServico)

    public String clienteNome;
    public String equipamentoDescricao;
    public String problemaRelatado;

    public String status = "ABERTA";
    public LocalDateTime dataAbertura = LocalDateTime.now();
    public LocalDateTime dataConclusao;
    public Double desconto = 0.0;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "os_id")
    public List<ItemServico> servicos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "os_id")
    public List<ItemPeca> pecas = new ArrayList<>();

    public OrdemDeServico() {
    }

    public OrdemDeServico(String clienteNome, String equipamentoDescricao, String problemaRelatado) {
        this.clienteNome = clienteNome;
        this.equipamentoDescricao = equipamentoDescricao;
        this.problemaRelatado = problemaRelatado;
    }

    // Método customizado para o Swagger conseguir ler o ID herdado da classe mãe sem vir nulo
    public Long getId() {
        return super.id;
    }

    public void adicionarServico(String descricao, Double valor) {
        this.servicos.add(new ItemServico(descricao, valor));
        calcularValorTotal();
    }

    public void concluir(Double desconto) {
        if (desconto == null || desconto < 0) {
            this.desconto = 0.0;
        } else {
            this.desconto = desconto;
        }
        this.status = "CONCLUIDA";
        this.dataConclusao = LocalDateTime.now();
        calcularValorTotal();
    }

    public void cancelar() {
        this.status = "CANCELADA";
    }

    public void calcularValorTotal() {
        if (this.desconto == null) {
            this.desconto = 0.0;
        }

        double totalServicos = 0.0;
        if (this.servicos != null) {
            for (ItemServico s : this.servicos) {
                if (s != null && s.valorTotal != null) {
                    totalServicos += s.valorTotal;
                }
            }
        }

        double totalPecas = 0.0;
        if (this.pecas != null) {
            for (ItemPeca p : this.pecas) {
                if (p != null) {
                    double preco = p.preco != null ? p.preco : 0.0;
                    int qtd = p.quantidade != null ? p.quantidade : 0;
                    totalPecas += preco * qtd;
                }
            }
        }

        double subtotal = (totalServicos > 0 || totalPecas > 0) ? (totalServicos + totalPecas) : (this.valorTotal != null ? this.valorTotal : 0.0);

        if (this.desconto > subtotal) {
            this.valorTotal = 0.0;
        } else {
            this.valorTotal = subtotal - this.desconto;
        }
    }
}
