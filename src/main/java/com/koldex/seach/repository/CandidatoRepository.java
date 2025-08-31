package com.koldex.seach.repository;

import com.koldex.seach.domain.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {}
