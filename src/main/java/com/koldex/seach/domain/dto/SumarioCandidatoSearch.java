package com.koldex.seach.domain.dto;

import com.koldex.seach.domain.TurnosEnum;
import com.koldex.seach.utils.Search;
import org.springframework.data.domain.Page;

// Representa todas as formas disponiveis de pesquisa de Candidatos
public interface SumarioCandidatoSearch extends Search<SumarioCandidatoResponse> {

    Page<SumarioCandidatoResponse> doCpf(String cpf);

    SumarioCandidatoSearch doTurno(TurnosEnum turno);

    SumarioCandidatoSearch daEtiniaPretoParto(Boolean etiniaPretoPardo);

    SumarioCandidatoSearch comEmail(String email);

    SumarioCandidatoSearch sendoPcd(Boolean pcd);

}
