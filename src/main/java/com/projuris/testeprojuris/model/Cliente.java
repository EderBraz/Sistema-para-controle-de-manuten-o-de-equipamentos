package com.projuris.testeprojuris.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Informe o nome do cliente")
    private String nome;
    @NotEmpty(message = "Informe o endereço do cliente")
    private String endereco;
    @NotBlank
    @Size(max = 20)
    private String telefone;
    @NotBlank
    @Email
    private String email;
    @OneToOne
    private Equipamento equipamento;
}
