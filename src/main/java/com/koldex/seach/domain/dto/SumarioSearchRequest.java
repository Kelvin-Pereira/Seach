package com.koldex.seach.domain.dto;

import com.koldex.seach.domain.TurnosEnum;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.function.BiFunction;

@Data
public class SumarioSearchRequest implements BiFunction<SumarioCandidatoSearchFilter, Sort, SumarioCandidatoSearchFilter> {

    // campos da tela (Filtro)
    public String cpf;
    public String email;
    public Boolean pcd;
    public TurnosEnum turno;


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
