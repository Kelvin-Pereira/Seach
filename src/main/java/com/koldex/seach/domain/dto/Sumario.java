package com.koldex.seach.domain.dto;

import lombok.Builder;
import lombok.Data;

// Representa as principais informacoes de um candidato
@Data
@Builder
public class Sumario {

    private Long id;
    private String nome;
    private String curso;
    private Boolean pcd;
    private Boolean isValidPcd;

}
