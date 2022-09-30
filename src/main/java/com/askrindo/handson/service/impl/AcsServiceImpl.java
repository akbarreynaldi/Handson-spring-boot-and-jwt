package com.askrindo.handson.service.impl;

import com.askrindo.handson.config.SSLContextHelper;
import com.askrindo.handson.model.dto.AccessTokenResponse;
import com.askrindo.handson.service.AcsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AcsServiceImpl implements AcsService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public String h2hLoginAcs() throws URISyntaxException {
        String username = "fadlym22@askrindo.co.id";
        String password = "Askrindo123";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String payload = "{\n" +
                "    \"username\": \"" + username + "\",\n" +
                "    \"password\": \"" + password + "\"\n" +
                "}";
        HttpEntity<String> request = new HttpEntity<>(payload, headers);
        SSLContextHelper.disable();
        ResponseEntity<AccessTokenResponse> response = restTemplate
                .exchange("https://10.20.10.5:8090/api/v1/kur/api/token", HttpMethod.POST, request, AccessTokenResponse.class);
        response.getBody();
        String token = response.getBody().getAccess_token();
        return token;
    }
}
