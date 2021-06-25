package com.projuris.testeprojuris.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate inicioAtendimento;
    private LocalDate fimAtendimento;
    private String detalhes;

    @Enumerated(EnumType.STRING)
    private StatusReparo status;

    @OneToOne
    private Cliente cliente;
}
