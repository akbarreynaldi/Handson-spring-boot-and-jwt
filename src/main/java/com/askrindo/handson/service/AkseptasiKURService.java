package com.askrindo.handson.service;

import com.askrindo.handson.model.dto.RequestACS;
import com.askrindo.handson.model.dto.ResponseA;

import java.net.URISyntaxException;

public interface AkseptasiKURService {
    public ResponseA akseptasiKUR(RequestACS requestACS) throws URISyntaxException;
}
