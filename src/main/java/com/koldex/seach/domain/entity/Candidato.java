package com.koldex.seach.domain.entity;

import com.koldex.seach.utils.BooleanSimNaoConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CANDIDATO", schema = "SEACH")
public class Candidato {

    @Id
    @GeneratedValue(generator = "SEQ_CANDIDATO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_CANDIDATO", sequenceName = "SEACH.SEQ_CANDIDATO", allocationSize = 1)
    private Long id;

    private String nome;

    @Column(name = "PCD", columnDefinition = "CHAR(1) DEFAULT 'N'")
    @Convert(converter = BooleanSimNaoConverter.class)
    private Boolean pcd;  // Pessoa com Deficiência

    @ManyToOne
    @JoinColumn(name = "CURSO_ID")
    private Curso curso;

}