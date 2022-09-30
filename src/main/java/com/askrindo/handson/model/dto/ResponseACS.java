package com.askrindo.handson.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseACS {
    @JsonProperty("no_rekening")
    private String noRekening;
    @JsonProperty("no_sertifikat")
    private String noSertifikat;
    @JsonProperty("tanggal_sertifikat")
    private String tanggalSertifikat;
    @JsonProperty("tanggal_rekam")
    private String tanggalRekam;
    @JsonProperty("alasan_tolak")
    private String alasanTolak;
    @JsonProperty("status")
    private String status;
}