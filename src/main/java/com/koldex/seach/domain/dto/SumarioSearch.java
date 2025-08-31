package com.koldex.seach.domain.dto;

import com.koldex.seach.utils.Search;
import org.springframework.data.domain.Page;

// Representa todas as formas disponiveis de pesquisa de Candidatos
public interface SumarioSearch extends Search<Sumario> {

    Page<Sumario> doCpf(String cpf);

    SumarioSearch doTurno(String turno);

    SumarioSearch daEtiniaPretoParto(Boolean etiniaPretoPardo);

    SumarioSearch comEmail(String email);

    SumarioSearch sendoPcd(Boolean pcd);

}
