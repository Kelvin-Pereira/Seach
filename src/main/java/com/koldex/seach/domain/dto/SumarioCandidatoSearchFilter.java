package com.koldex.seach.domain.dto;

import com.koldex.seach.domain.TurnosEnum;
import com.koldex.seach.utils.SearchFilter;
import org.springframework.data.domain.Page;

// Representa todas as formas disponiveis de pesquisa de Candidatos
public interface SumarioCandidatoSearchFilter extends SearchFilter<SumarioCandidatoResponse> {

    Page<SumarioCandidatoResponse> doCpf(String cpf);

    SumarioCandidatoSearchFilter doTurno(TurnosEnum turno);

    SumarioCandidatoSearchFilter daEtiniaPretoParto(Boolean etiniaPretoPardo);

    SumarioCandidatoSearchFilter comEmail(String email);

    SumarioCandidatoSearchFilter sendoPcd(Boolean pcd);

}
