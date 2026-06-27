package com.exemplo.manutencao.repository;

import com.exemplo.manutencao.model.OrdemDeServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemDeServico, Long> {
}
