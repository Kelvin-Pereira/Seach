package com.koldex.seach.repository;

import com.koldex.seach.domain.entity.Area;
import com.koldex.seach.domain.entity.Candidato;
import com.koldex.seach.domain.entity.Curso;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Join;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CandidatoSpecification implements Specification<Candidato> {

    private final String turno;
    private final Boolean pcd;
    private final Boolean etiniaPretoPardo;
    private final String email;

    @Override
    public Predicate toPredicate(Root<Candidato> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        // Adiciona um predicado para o filtro de PCD, se ele existir
        if (pcd != null) {
            predicates.add(criteriaBuilder.equal(root.get("pcd"), pcd));
        }

        // Adiciona um predicado para o filtro de turno, se ele existir
        if (turno != null) {
            Join<Candidato, Curso> cursoJoin = root.join("curso");
            Join<Curso, Area> areaJoin = cursoJoin.join("area");

            // Cria um "ou" lógico para os possíveis turnos (matutino, vespertino, noturno)
            Predicate turnoPredicate;
            if ("Matutino".equalsIgnoreCase(turno)) {
                turnoPredicate = criteriaBuilder.equal(areaJoin.get("indMatutino"), true);
            } else if ("Vespertino".equalsIgnoreCase(turno)) {
                turnoPredicate = criteriaBuilder.equal(areaJoin.get("indVespertino"), true);
            } else if ("Noturno".equalsIgnoreCase(turno)) {
                turnoPredicate = criteriaBuilder.equal(areaJoin.get("indNoturno"), true);
            } else {
                turnoPredicate = criteriaBuilder.conjunction(); // Predicado que sempre é verdadeiro
            }
            predicates.add(turnoPredicate);
        }

        // Lógica para os filtros de etnia e email
        // Esses campos não estão definidos nas classes de entidade fornecidas,
        // mas o código ficaria assim se estivessem:
        if (etiniaPretoPardo != null) {
            // Exemplo: predicates.add(criteriaBuilder.equal(root.get("etiniaPretoPardo"), etiniaPretoPardo));
        }
        if (email != null) {
            // Exemplo: predicates.add(criteriaBuilder.equal(root.get("email"), email));
        }

        // Combina todos os predicados com um "E" lógico (AND)
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}