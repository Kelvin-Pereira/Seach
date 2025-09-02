package com.koldex.seach.domain.dto;

import com.koldex.seach.domain.TurnosEnum;
import com.koldex.seach.utils.SearchFilter;
import org.springframework.data.domain.Page;

// Representa todas as formas disponiveis de pesquisa de Candidatos
public interface CandidatoSearchFilter extends SearchFilter<CandidatoResponse> {

    Page<CandidatoResponse> doCpf(String cpf);

    CandidatoSearchFilter doTurno(TurnosEnum turno);

    CandidatoSearchFilter daEtiniaPretoParto(Boolean etiniaPretoPardo);

    CandidatoSearchFilter comEmail(String email);

    CandidatoSearchFilter sendoPcd(Boolean pcd);

}
