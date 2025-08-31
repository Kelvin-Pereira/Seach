package com.koldex.seach.domain.dto;

import com.koldex.seach.domain.TurnosEnum;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.function.BiFunction;

@Data
public class SumarioSearchRequest implements BiFunction<SumarioCandidatoSearch, Sort, SumarioCandidatoSearch> {

    // campos da tela (Filtro)
    public String cpf;
    public String email;
    public Boolean pcd;
    public TurnosEnum turno;


    @Override
    public SumarioCandidatoSearch apply(SumarioCandidatoSearch search, Sort orders) {
        SumarioCandidatoSearch sumarios = search;

        if (turno != null) {
            sumarios = sumarios.doTurno(turno);
        }

        if (pcd != null) {
            sumarios = sumarios.sendoPcd(pcd);
        }

        return sumarios;
    }


}
