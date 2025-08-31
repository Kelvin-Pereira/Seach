package com.koldex.seach.controller;

import com.koldex.seach.domain.dto.SumarioSearch;
import com.koldex.seach.domain.dto.SumarioSearchReq;
import com.koldex.seach.service.CandidatoSearchApi;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<?> findSearch(@ModelAttribute SumarioSearchReq req, @PageableDefault Pageable pageable) {
        SumarioSearch sumario = candidatoSearchApi.sumario();
        if (req.getCpf() != null) {
            return ResponseEntity.ok(sumario.doCpf(req.cpf));
        }
        return ResponseEntity.ok(req.apply(sumario, pageable.getSort()).search());
    }

}
