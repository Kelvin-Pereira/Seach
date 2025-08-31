package com.koldex.seach.service;

import com.koldex.seach.domain.dto.SumarioCandidatoSearch;
import com.koldex.seach.repository.CandidatoSearchBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CandidatoRepositoryCustom implements CandidatoSearchApi {

    @PersistenceContext
    private EntityManager em;

    @Override
    public SumarioCandidatoSearch sumario() {
        return  new CandidatoSearchBuilder(em);
    }
}
