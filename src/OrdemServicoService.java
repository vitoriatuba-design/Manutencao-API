package com.exemplo.manutencao.service;

import com.exemplo.manutencao.model.OrdemDeServico;
import com.exemplo.manutencao.repository.OrdemServicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository repository;

    public OrdemServicoService(OrdemServicoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public OrdemDeServico criar(OrdemDeServico os) {
        if (os.valorTotal == null) {
            os.valorTotal = 0.0;
        }
        os.calcularValorTotal();
        return repository.saveAndFlush(os);
    }

    @Transactional
    public OrdemDeServico adicionarServico(Long id, String descricao, Double valor) {
        OrdemDeServico os = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada"));
        os.adicionarServico(descricao, valor);
        return repository.saveAndFlush(os);
    }

    @Transactional
    public OrdemDeServico concluir(Long id, Double desconto) {
        OrdemDeServico os = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordem de serviço não encontrada"));
        os.concluir(desconto);
        return repository.saveAndFlush(os);
    }

    public List<OrdemDeServico> listarTodas() {
        return repository.findAll();
    }
}
