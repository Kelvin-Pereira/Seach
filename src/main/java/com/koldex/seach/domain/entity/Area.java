package com.koldex.seach.domain.entity;

import com.koldex.seach.utils.BooleanSimNaoConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "AREA", schema = "SEACH")
public class Area {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SEQ_AREA", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_AREA", sequenceName = "SEACH.SEQ_AREA", allocationSize = 1)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "IND_MATUTINO", columnDefinition = "CHAR(1) DEFAULT 'N'")
    @Convert(converter = BooleanSimNaoConverter.class)
    private Boolean indMatutino;

    @Column(name = "IND_VESPERTINO", columnDefinition = "CHAR(1) DEFAULT 'N'")
    @Convert(converter = BooleanSimNaoConverter.class)
    private Boolean indVespertino;

    @Column(name = "IND_NOTURNO", columnDefinition = "CHAR(1) DEFAULT 'N'")
    @Convert(converter = BooleanSimNaoConverter.class)
    private Boolean indNoturno;

    @Column(name = "DATA_REGISTRO")
    private LocalDateTime dataRegistro;

    @PreUpdate
    public void preUpdate() {
        this.dataRegistro = LocalDateTime.now();
    }

}
