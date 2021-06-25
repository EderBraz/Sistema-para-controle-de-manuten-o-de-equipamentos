package com.projuris.testeprojuris.service.impl;

import com.projuris.testeprojuris.model.OrdemServico;
import com.projuris.testeprojuris.repository.OrdemServicoRepository;
import com.projuris.testeprojuris.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService {

    @Autowired
    OrdemServicoRepository repository;

    public List<OrdemServico> findAll(){
        return repository.findAll();
    }

    public OrdemServico save(OrdemServico ordem){
        return repository.save(ordem);
    }

    public List<OrdemServico> buscarOrdemPendentePorResponsavel(String nome){
        return repository.buscarOrdemPendentePorResponsavel(nome);

    }
}
