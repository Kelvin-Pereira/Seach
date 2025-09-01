package com.koldex.seach.service;

import com.koldex.seach.domain.dto.SumarioCandidatoSearchFilter;
import com.koldex.seach.repository.CandidatoSearchFilterBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CandidatoRepositoryCustom implements CandidatoSearchApi {

    @PersistenceContext
    private EntityManager em;

    @Override
    public SumarioCandidatoSearchFilter sumario() {
        return  new CandidatoSearchFilterBuilder(em);
    }
}
