package com.koldex.seach.service;

import com.koldex.seach.domain.dto.Sumario;
import com.koldex.seach.domain.dto.SumarioCandidatoSearch;
import com.koldex.seach.domain.entity.Candidato;
import com.koldex.seach.repository.CandidatoRepository;
import com.koldex.seach.repository.CandidatoSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@RequiredArgsConstructor
public class SumarioCandidatoSearchImpl implements SumarioCandidatoSearch {

    private final CandidatoRepository candidatoRepository;

    private String cpf;
    private String turno;
    private Boolean etiniaPretoParto;
    private String email;
    private Boolean pcd;

    @Override
    public Page<Sumario> doCpf(String cpf) {
        return Page.empty();
    }

    @Override
    public SumarioCandidatoSearch doTurno(String turno) {
        this.turno = turno;
        return this;
    }

    @Override
    public SumarioCandidatoSearch daEtiniaPretoParto(Boolean etiniaPretoPardo) {
        this.etiniaPretoParto = etiniaPretoPardo;
        return this;
    }

    @Override
    public SumarioCandidatoSearch comEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public SumarioCandidatoSearch sendoPcd(Boolean pcd) {
        this.pcd = pcd;
        return this;
    }

    @Override
    public Page<Sumario> search() {
        // Implementação sem paginação
        return search(Pageable.unpaged());
    }

    @Override
    public Page<Sumario> search(Pageable pageable) {
        Specification<Candidato> spec = new CandidatoSpecification(this.turno, this.pcd, this.etiniaPretoParto, this.email);
        Page<Candidato> candidatosPage = candidatoRepository.findAll(spec, pageable);
        List<Sumario> sumarios = candidatosPage.getContent().stream()
                .map(candidato ->
                     Sumario.builder()
                            .id(candidato.getId())
                            .nome(candidato.getNome())
                            .curso(candidato.getCurso().getNome())
                            .pcd(candidato.getPcd())
                            .build()
                ).toList();
        return new PageImpl<>(sumarios, candidatosPage.getPageable(), candidatosPage.getTotalElements());
    }
}