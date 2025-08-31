package com.koldex.seach.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Boolean pcd;  // Pessoa com Deficiência

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

}