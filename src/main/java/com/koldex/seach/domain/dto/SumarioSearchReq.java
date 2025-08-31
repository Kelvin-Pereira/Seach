package com.koldex.seach.domain.dto;

import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.function.BiFunction;

@Data
public class SumarioSearchReq implements BiFunction<SumarioSearch, Sort, SumarioSearch> {

    // campos da tela (Filtro)
    public String cpf;
    public String email;
    public Boolean pcd;
    public String turrno;


    @Override
    public SumarioSearch apply(SumarioSearch search, Sort orders) {
        SumarioSearch sumarios = search;

        if (turrno != null) {
            sumarios = sumarios.doTurno(turrno);
        }

        if (pcd != null) {
            sumarios = sumarios.sendoPcd(pcd);
        }

        return sumarios;
    }


}
