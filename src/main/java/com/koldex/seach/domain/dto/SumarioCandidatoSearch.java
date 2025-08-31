package com.koldex.seach.domain.dto;

import com.koldex.seach.utils.Search;
import org.springframework.data.domain.Page;

public interface SumarioCandidatoSearch extends Search<SumarioCandidato> {

    Page<SumarioCandidato> comCpf(String cpf);

    Page<SumarioCandidato> comEmail(String email);

    SumarioCandidatoSearch pcd(Boolean pcd);

    SumarioCandidatoSearch turno(String turno);

    SumarioCandidatoSearch comArea(Long idArea);

    SumarioCandidatoSearch pretoPardo(Boolean pretoPardo);

}
