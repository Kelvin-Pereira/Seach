package com.koldex.seach.domain.dto;

import com.koldex.seach.domain.TurnosEnum;
import org.springframework.data.domain.Sort;

import java.util.function.BiFunction;

public record SumarioSearchRequest(
        String cpf,
        String email,
        Boolean pcd,
        TurnosEnum turno
) implements BiFunction<SumarioCandidatoSearchFilter, Sort, SumarioCandidatoSearchFilter> {

    @Override
    public SumarioCandidatoSearchFilter apply(SumarioCandidatoSearchFilter search, Sort orders) {
        SumarioCandidatoSearchFilter sumarios = search;

        if (turno != null) {
            sumarios = sumarios.doTurno(turno);
        }

        if (pcd != null) {
            sumarios = sumarios.sendoPcd(pcd);
        }

        return sumarios;
    }
}
