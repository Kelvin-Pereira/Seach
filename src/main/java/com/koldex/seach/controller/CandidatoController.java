package com.koldex.seach.controller;

import com.koldex.seach.domain.entity.Candidato;
import com.koldex.seach.repository.CandidatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("candidato")
@RequiredArgsConstructor
public class CandidatoController {

    private final CandidatoRepository candidatoRepository;

    @GetMapping("/search")
   public ResponseEntity<List<Candidato>> findAll() {
        return ResponseEntity.ok(candidatoRepository.findAll());
    }

}
