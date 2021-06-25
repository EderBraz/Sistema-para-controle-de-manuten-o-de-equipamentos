package com.projuris.testeprojuris.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.projuris.testeprojuris.model.Cliente;
import com.projuris.testeprojuris.model.Responsavel;
import com.projuris.testeprojuris.model.StatusReparo;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdemServicoDTO {

    private Long id;

    @NotNull
    private LocalDate inicioAtendimento;
    private LocalDate fimAtendimento;
    private String detalhes;
    @NotNull
    private StatusReparo status;
    @NotNull
    private Cliente cliente;
    @NotNull
    private Responsavel responsavel;
}
