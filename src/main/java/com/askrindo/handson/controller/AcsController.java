package com.askrindo.handson.controller;

import com.askrindo.handson.model.dto.AccessTokenResponse;
import com.askrindo.handson.service.AcsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AcsController {

    private final AcsService acsService;

    @PostMapping("/token")
    public ResponseEntity<AccessTokenResponse> h2hLoginAcs() throws URISyntaxException {
        AccessTokenResponse response = new AccessTokenResponse();
        response.setAccess_token(acsService.h2hLoginAcs());
        return ResponseEntity.ok(response);
    }
}
