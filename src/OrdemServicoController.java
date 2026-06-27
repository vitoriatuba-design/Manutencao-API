package com.exemplo.manutencao.controller;

import com.exemplo.manutencao.model.OrdemDeServico;
import com.exemplo.manutencao.service.OrdemServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordens-servico")
public class OrdemServicoController {

    private final OrdemServicoService service;

    public OrdemServicoController(OrdemServicoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrdemDeServico> criar(@RequestBody OrdemDeServico os) {
        return new ResponseEntity<>(service.criar(os), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/servicos")
    public ResponseEntity<OrdemDeServico> adicionarServico(
            @PathVariable Long id,
            @RequestParam String descricao,
            @RequestParam Double valor) {
        return ResponseEntity.ok(service.adicionarServico(id, descricao, valor));
    }

    @PatchMapping("/{id}/concluir")
    public ResponseEntity<OrdemDeServico> concluir(
            @PathVariable Long id,
            @RequestParam(required = false, defaultValue = "0.0") Double desconto) {
        return ResponseEntity.ok(service.concluir(id, desconto));
    }

    @GetMapping
    public ResponseEntity<List<OrdemDeServico>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }
}
