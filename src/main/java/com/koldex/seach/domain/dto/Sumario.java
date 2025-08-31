package com.koldex.seach.domain.dto;

// Representa as principais informacoes de um candidato
public interface Sumario {

    Long id();
    String nome();
    String turno();
    String curso();
    Boolean pcd();
    Boolean isValidPcd();

}
