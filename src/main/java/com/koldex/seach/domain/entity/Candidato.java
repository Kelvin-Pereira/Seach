package com.koldex.seach.domain.entity;

import com.koldex.seach.utils.BooleanSimNaoConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CANDIDATO", schema = "SEARCH")
public class Candidato {

    @Id
    @GeneratedValue(generator = "SEQ_CANDIDATO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_CANDIDATO", sequenceName = "SEARCH.SEQ_CANDIDATO", allocationSize = 1)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "PCD", columnDefinition = "CHAR(1) DEFAULT 'N'")
    @Convert(converter = BooleanSimNaoConverter.class)
    private Boolean pcd;  // Pessoa com Deficiência

    @Column(name = "IND_PCD_VALID", columnDefinition = "CHAR(1) DEFAULT 'N'")
    @Convert(converter = BooleanSimNaoConverter.class)
    private Boolean isValid;  // Pessoa com Deficiência

    @ManyToOne
    @JoinColumn(name = "CURSO_ID")
    private Curso curso;

}