package com.koldex.seach.repository;

import com.koldex.seach.domain.TurnosEnum;
import com.koldex.seach.domain.dto.CandidatoResponse;
import com.koldex.seach.domain.dto.CandidatoSearchFilter;
import com.koldex.seach.domain.entity.Candidato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.*;

@RequiredArgsConstructor
public class CandidatoSearchFilterBuilder implements CandidatoSearchFilter {

    private final EntityManager em;
    String baseQuery = "SELECT c FROM Candidato c";

    private Set<String> where = new LinkedHashSet<>();
    private final Map<String, Object> params = new HashMap<>();

    @Override
    public Page<CandidatoResponse> doCpf(String cpf) {
        where = Collections.singleton("c.cpf=:cpf");
        params.put("cpf", cpf);
        return search(Pageable.unpaged());
    }

    @Override
    public CandidatoSearchFilter doTurno(TurnosEnum turno) {
        switch (turno) {
            case MATUTINO:
                where.add("c.curso.area.indMatutino = true");
                break;
            case VESPERTINO:
                where.add("c.curso.area.indVespertino = true");
                break;
            case NOTURNO:
                where.add("c.curso.area.indNoturno = true");
                break;
        }
        return this;
    }

    @Override
    public CandidatoSearchFilter daEtiniaPretoParto(Boolean etiniaPretoPardo) {
        return null;
    }

    @Override
    public CandidatoSearchFilter comEmail(String email) {
        return null;
    }

    @Override
    public CandidatoSearchFilter sendoPcd(Boolean pcd) {
        where.add("c.pcd = :pcd");
        params.put("pcd", pcd);
        return this;
    }

    @Override
    public Page<CandidatoResponse> search(Pageable pageable) {
        StringBuilder jpql = new StringBuilder(baseQuery);

        if (!where.isEmpty()) {
            jpql.append(" WHERE ")
                    .append(String.join(" AND ", where));
        }

        TypedQuery<Candidato> query = em.createQuery(jpql.toString(), Candidato.class);
        params.forEach(query::setParameter);

        // paginação
        if (pageable.isPaged()) {
            query.setFirstResult((int) pageable.getOffset());
            query.setMaxResults(pageable.getPageSize());
        }

        List<Candidato> resultList = query.getResultList();

        // mapeando para DTO
        List<CandidatoResponse> dtos = resultList.stream()
                .map(c -> CandidatoResponse.builder()
                        .id(c.getId())
                        .nome(c.getNome())
                        .curso(c.getCurso() != null ? c.getCurso().getNome() : null)
                        .pcd(c.getPcd())
                        .isValidPcd(c.getIsValid()) // regra sua
                        .build()
                )
                .toList();

        // contar total (para o Page)
        StringBuilder countQuery = new StringBuilder("SELECT COUNT(c) FROM Candidato c");
        if (!where.isEmpty()) {
            countQuery.append(" WHERE ").append(String.join(" AND ", where));
        }

        TypedQuery<Long> count = em.createQuery(countQuery.toString(), Long.class);
        params.forEach(count::setParameter);
        Long total = count.getSingleResult();

        return new PageImpl<>(dtos, pageable, total);
    }


    @Override
    public Page<CandidatoResponse> search() {
        return search(Pageable.unpaged());
    }
}
