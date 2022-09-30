package com.askrindo.handson.controller;

import com.askrindo.handson.model.dto.RequestACS;
import com.askrindo.handson.service.impl.AkseptasiKURServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/penjaminan")
@RequiredArgsConstructor
public class AkseptasiKURController {
    private final AkseptasiKURServiceImpl kurService;

    @PostMapping
    public ResponseEntity<?> akseptasiKUR(@RequestBody RequestACS requestACS) throws URISyntaxException {
        return ResponseEntity.ok(kurService.akseptasiKUR(requestACS));
    }
}
