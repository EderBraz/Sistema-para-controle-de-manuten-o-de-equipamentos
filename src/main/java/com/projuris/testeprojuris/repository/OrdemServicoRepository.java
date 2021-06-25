package com.projuris.testeprojuris.repository;

import com.projuris.testeprojuris.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

    @Query(value = "SELECT a FROM OrdemServico a WHERE a.status=PENDENTE AND a.responsavel.nome = :nome")

    List<OrdemServico> buscarOrdemPendentePorResponsavel(String nome);
}

