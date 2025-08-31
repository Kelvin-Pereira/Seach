package com.koldex.seach.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CURSO", schema = "SEACH")
public class Curso {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SEQ_CURSO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_CURSO", sequenceName = "SEACH.SEQ_CURSO", allocationSize = 1)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "AREA_ID")
    private Area area;

}