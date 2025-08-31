package com.koldex.seach.domain.dto;

import com.koldex.seach.utils.Search;
import org.springframework.data.domain.Page;

// Representa todas as formas disponiveis de pesquisa de Candidatos
public interface SumarioCandidatoSearch extends Search<Sumario> {

    Page<Sumario> doCpf(String cpf);

    SumarioCandidatoSearch doTurno(String turno);

    SumarioCandidatoSearch daEtiniaPretoParto(Boolean etiniaPretoPardo);

    SumarioCandidatoSearch comEmail(String email);

    SumarioCandidatoSearch sendoPcd(Boolean pcd);

}
