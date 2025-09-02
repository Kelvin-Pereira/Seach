package com.koldex.seach.controller;

import com.koldex.seach.domain.dto.CandidatoResponse;

import com.koldex.seach.domain.dto.CandidatoSearchFilter;
import com.koldex.seach.domain.dto.CandidatoSearchRequest;
import com.koldex.seach.service.CandidatoSearchApi;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("candidato")
@RequiredArgsConstructor
public class CandidatoController {

    private final CandidatoSearchApi candidatoSearchApi;

    @GetMapping("/search")
    public ResponseEntity<Page<CandidatoResponse>> findSearch(@ModelAttribute CandidatoSearchRequest req, @PageableDefault(size = 2) Pageable pageable) {
        CandidatoSearchFilter filter = candidatoSearchApi.filter();
        if (req.cpf() != null) {
            return ResponseEntity.ok(filter.doCpf(req.cpf()));
        }
        return ResponseEntity.ok(req.apply(filter).search(pageable));
    }

}
