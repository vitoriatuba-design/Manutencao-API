package com.exemplo.manutencao.dto;

import java.time.LocalDateTime;

public record OrdemServicoDTO(
    Long id,
    String clienteNome,
    String equipamentoDescricao,
    String problemaRelatado,
    String status,
    LocalDateTime dataAbertura,
    Double valorTotal
) {}
