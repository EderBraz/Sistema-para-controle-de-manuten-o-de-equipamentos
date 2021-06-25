package com.projuris.testeprojuris.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
