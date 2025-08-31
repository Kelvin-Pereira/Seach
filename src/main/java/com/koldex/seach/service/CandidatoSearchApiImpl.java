package com.koldex.seach.service;

import com.koldex.seach.domain.dto.SumarioSearch;
import com.koldex.seach.repository.CandidatoRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidatoSearchApiImpl implements CandidatoSearchApi {

    private final CandidatoRepository candidatoRepository;

    public CandidatoSearchApiImpl(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    @Override
    public SumarioSearch sumario() {
        return new SumarioSearchImpl(candidatoRepository);
    }
}
