package com.projuris.testeprojuris.controller;

import com.projuris.testeprojuris.Response;
import com.projuris.testeprojuris.dto.OrdemServicoDTO;
import com.projuris.testeprojuris.model.OrdemServico;
import com.projuris.testeprojuris.service.OrdemServicoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/ordens")
public class OrdemServicoController {

    @Autowired
    OrdemServicoService service;

    /**
     * Busca todas as ordens de serviço.
     *
     * @return ResponseEntity com uma List<OrdemServico> e HTTP status 200.
     */
    @GetMapping
    @ApiOperation(value = "Lista todas ordens de serviço.")
    public ResponseEntity<List<OrdemServico>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    /**
     * Busca ordens de serviços pendentes utilizando o nome do responsável.
     *
     * @param nome nome do Responsável
     * @return List lista de OrdemServico
     */
    @GetMapping(value = "/buscar-ordem-pendente-por-responsavel/{nome}")
    @ApiOperation(value = "Busca ordens de serviços pendentes utilizando o nome do responsável.")
    public List<OrdemServico> consultarOrdemPendentePorResponsavel(@PathVariable("nome") String nome) {
        return service.buscarOrdemPendentePorResponsavel(nome);
    }

    /**
     * Salva Ordem de Serviço.
     *
     * @param dto    :
     * - inicioAtendimento
     * - Data do atendimento no formato YYYY-MM-DD;
     * - fimAtendimento - Data da finalização do atendmento no formato YYYY-MM-DD;
     * - detalhes - Detalhes da ordem de serviço;
     * - status - Situação do pedido(ABERTO, PENDENTE, FINALIZADO);
     * - cliente - Objeto cliente;
     * - responsavel - Objeto responsavel;
     * @param result Bind result
     * @return ResponseEntity com o Response<OrdemServicoDTO> objeto e Status HTTP.
     */
    @PostMapping
    @ApiOperation(value = "Cadastra uma nova ordem de serviço.")
    public ResponseEntity<Response<OrdemServicoDTO>> save(@Valid @RequestBody OrdemServicoDTO dto, BindingResult result) {
        Response<OrdemServicoDTO> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        OrdemServico ordem = service.save(this.convertDtoToEntity(dto));
        response.setData(this.convertEntityToDto(ordem));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Converte a entidade OrdemServico para um DTO.
     *
     * @param o Objeto OrdemServico
     * @return OrdemServicoDTO
     */
    private OrdemServicoDTO convertEntityToDto(OrdemServico o) {
        OrdemServicoDTO dto = new OrdemServicoDTO();

        dto.setId(o.getId());
        dto.setInicioAtendimento(o.getInicioAtendimento());
        dto.setFimAtendimento(o.getFimAtendimento());
		dto.setDetalhes(o.getDetalhes());
		dto.setStatus(o.getStatus());
		dto.setCliente(o.getCliente());
		dto.setResponsavel(o.getResponsavel());
        return dto;
    }

    /**
     * Converte o DTO para uma entidade OrdemServico
     * @param dto OrdemServicoDTO
     * @return o OrdemServico
     */
    private OrdemServico convertDtoToEntity(OrdemServicoDTO dto) {
        OrdemServico o = new OrdemServico();

        o.setId(dto.getId());
        o.setInicioAtendimento(dto.getInicioAtendimento());
        o.setFimAtendimento(dto.getFimAtendimento());
        o.setDetalhes(dto.getDetalhes());
        o.setStatus(dto.getStatus());
        o.setCliente(dto.getCliente());
        o.setResponsavel(dto.getResponsavel());
        return o;
    }

}
