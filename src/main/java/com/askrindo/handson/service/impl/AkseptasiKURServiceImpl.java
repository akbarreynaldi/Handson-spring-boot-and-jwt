package com.askrindo.handson.service.impl;

import com.askrindo.handson.config.SSLContextHelper;
import com.askrindo.handson.model.dto.RequestACS;
import com.askrindo.handson.model.dto.ResponseA;
import com.askrindo.handson.service.AkseptasiKURService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AkseptasiKURServiceImpl implements AkseptasiKURService {
    @Override
    public ResponseA akseptasiKUR(RequestACS requestACS) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
//        RequestACS payload = new RequestACS();
        AcsServiceImpl acsService = new AcsServiceImpl();

//        payload.setNoRekening("013611018785");
//        payload.setCif("3402167011550001");
//        payload.setNoPk("059611003544");
//        payload.setTglPk("20210812");
//        payload.setTglAwal("20210812");
//        payload.setTglJatuhTempo("20230812");
//        payload.setJenisKredit("1");
//        payload.setJenisKur("1");
//        payload.setKodeUker("013");
//        payload.setKodeBank("23");
//        payload.setNamaDebitur("ponirah");
//        payload.setAlamatDebitur("bekelanRt003Rw000TirtonirmoloKasihanBantul");
//        payload.setKodePos("55181");
//        payload.setTglLahir("20230812");
//        payload.setJk(2);
//        payload.setNoTelepon("0");
//        payload.setNoHp("0000000000");
//        payload.setKtpDebitur("3402167011550001");
//        payload.setNpwp("000000000000000");
//        payload.setNoIjinUsaha("0290\\/legi\\/227");
//        payload.setPlafonKredit(12000000);
//        payload.setJw(24);
//        payload.setKodeSektor("522200");
//        payload.setJmlTenaker(0);
//        payload.setCabangRekanan("26");
//        payload.setTanggalRekam("20210812");
//        payload.setJenisLinkage("n");
//        payload.setLembagaLinkage("");
//        payload.setStatus("l");
//        payload.setKolektibilitas("1");
//        payload.setModalUsaha(18000000);
//        payload.setAlamatUsaha("pasarLegi");
//        payload.setTanggalMulaiUsaha("20100811");
//        payload.setOmsetUsaha(48600000);

        String token = acsService.h2hLoginAcs();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        HttpEntity<?> request = new HttpEntity<>(requestACS, headers);
        SSLContextHelper.disable();
        ResponseEntity<ResponseA> response = restTemplate
                .exchange("https://10.20.10.5:8090/api/v1/kur/api/penjaminan", HttpMethod.POST, request, ResponseA.class);
        log.info(response.getBody().toString());
        return response.getBody();
    }
}
