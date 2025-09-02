package com.koldex.seach.domain.dto;

import com.koldex.seach.domain.TurnosEnum;

import java.util.function.Function;

public record SumarioSearchRequest(
        String cpf,
        String email,
        Boolean pcd,
        TurnosEnum turno
) implements Function<CandidatoSearchFilter, CandidatoSearchFilter> {

    @Override
    public CandidatoSearchFilter apply(CandidatoSearchFilter search) {
        CandidatoSearchFilter sumarios = search;

        if (turno != null) {
            sumarios = sumarios.doTurno(turno);
        }

        if (pcd != null) {
            sumarios = sumarios.sendoPcd(pcd);
        }

        return sumarios;
    }
}
