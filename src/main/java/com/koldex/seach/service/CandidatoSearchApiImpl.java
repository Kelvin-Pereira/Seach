package com.koldex.seach.service;

import com.koldex.seach.domain.dto.SumarioCandidatoSearch;
import com.koldex.seach.repository.CandidatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidatoSearchApiImpl implements CandidatoSearchApi {

    private final CandidatoRepository candidatoRepository;

    @Override
    public SumarioCandidatoSearch sumario() {
        return new SumarioCandidatoSearchImpl(candidatoRepository);
    }
}
