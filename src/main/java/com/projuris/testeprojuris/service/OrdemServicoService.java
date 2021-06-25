package com.projuris.testeprojuris.service;

import com.projuris.testeprojuris.model.OrdemServico;

import java.util.List;

/**
 * The interface Ordem servico service.
 */
public interface OrdemServicoService {

    /**
     * Lista todas as ordens de servico.
     *
     * @return List
     */
    List<OrdemServico> findAll();

    /**
     * Lista todas as ordens pendentes pelo nome do responsavel .
     *
     * @param nome nome do Responsável
     * @return List
     */
    List<OrdemServico> buscarOrdemPendentePorResponsavel(String nome);

    /**
     * Salva a ordem de servico.
     *
     * @param ordem Objeto OrdemServico
     * @return OrdemServico
     */
    OrdemServico save(OrdemServico ordem);
}
