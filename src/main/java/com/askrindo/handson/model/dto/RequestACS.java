package com.askrindo.handson.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestACS {
    @JsonProperty("no_rekening")
    private String noRekening;
    @JsonProperty("cif")
    private String cif;
    @JsonProperty("no_pk")
    private String noPk;
    @JsonProperty("tgl_pk")
    private String tglPk;
    @JsonProperty("tgl_awal")
    private String tglAwal;
    @JsonProperty("tgl_jatuh_tempo")
    private String tglJatuhTempo;
    @JsonProperty("jenis_kredit")
    private String jenisKredit;
    @JsonProperty("jenis_kur")
    private String jenisKur;
    @JsonProperty("kode_uker")
    private String kodeUker;
    @JsonProperty("kode_bank")
    private String kodeBank;
    @JsonProperty("nama_debitur")
    private String namaDebitur;
    @JsonProperty("alamat_debitur")
    private String alamatDebitur;
    @JsonProperty("kode_pos")
    private String kodePos;
    @JsonProperty("tgl_lahir")
    private String tglLahir;
    @JsonProperty("jk")
    private Integer jk;
    @JsonProperty("no_telepon")
    private String noTelepon;
    @JsonProperty("no_hp")
    private String noHp;
    @JsonProperty("ktp_debitur")
    private String ktpDebitur;
    @JsonProperty("npwp")
    private String npwp;
    @JsonProperty("no_ijin_usaha")
    private String noIjinUsaha;
    @JsonProperty("plafon_kredit")
    private Integer plafonKredit;
    @JsonProperty("jw")
    private Integer jw;
    @JsonProperty("kode_sektor")
    private String kodeSektor;
    @JsonProperty("jml_tenaker")
    private Integer jmlTenaker;
    @JsonProperty("cabang_rekanan")
    private String cabangRekanan;
    @JsonProperty("tanggal_rekam")
    private String tanggalRekam;
    @JsonProperty("jenis_linkage")
    private String jenisLinkage;
    @JsonProperty("lembaga_linkage")
    private String lembagaLinkage;
    @JsonProperty("status")
    private String status;
    @JsonProperty("kolektibilitas")
    private String kolektibilitas;
    @JsonProperty("modal_usaha")
    private Integer modalUsaha;
    @JsonProperty("alamat_usaha")
    private String alamatUsaha;
    @JsonProperty("tanggal_mulai_usaha")
    private String tanggalMulaiUsaha;
    @JsonProperty("omset_usaha")
    private Integer omsetUsaha;


    @Override
    public String toString() {
        return "{" + "\n" +
                "    \"no_rekening\": \"" + noRekening + "\",\n" +
                "    \"cif\": \"" + cif + "\",\n" +
                "    \"no_pk\": \"" + noPk + "\",\n" +
                "    \"tgl_pk\": \"" + tglPk + "\",\n" +
                "    \"tgl_awal\": \"" + tglAwal + "\",\n" +
                "    \"tgl_jatuh_tempo\": \"" + tglJatuhTempo + "\",\n" +
                "    \"jenis_kredit\": \"" + jenisKredit + "\",\n" +
                "    \"jenis_kur\": \"" + jenisKur + "\",\n" +
                "    \"kode_uker\": \"" + kodeUker + "\",\n" +
                "    \"kode_bank\": \"" + kodeBank + "\",\n" +
                "    \"nama_debitur\": \"" + namaDebitur + "\",\n" +
                "    \"alamat_debitur\": \"" + alamatDebitur + "\",\n" +
                "    \"kode_pos\": \"" + kodePos + "\",\n" +
                "    \"tgl_lahir\": \"" + tglLahir + "\",\n" +
                "    \"jk\": " + jk + ",\n" +
                "    \"no_telepon\": \"" + noTelepon + "\",\n" +
                "    \"no_hp\": \"" + noHp + "\",\n" +
                "    \"ktp_debitur\": \"" + ktpDebitur + "\",\n" +
                "    \"npwp\": \"" + npwp + "\",\n" +
                "    \"no_ijin_usaha\": \"" + noIjinUsaha + "\",\n" +
                "    \"plafon_kredit\": " + plafonKredit + ",\n" +
                "    \"jw\": " + jw + ",\n" +
                "    \"kode_sektor\": \"" + kodeSektor + "\",\n" +
                "    \"jml_tenaker\": " + jmlTenaker + ",\n" +
                "    \"cabang_rekanan\": \"" + cabangRekanan + "\",\n" +
                "    \"tanggal_rekam\": \"" + tanggalRekam + "\",\n" +
                "    \"jenis_linkage\": \"" + jenisLinkage + "\",\n" +
                "    \"lembaga_linkage\": \"" + lembagaLinkage + "\",\n" +
                "    \"status\": \"" + status + "\",\n" +
                "    \"kolektibilitas\": \"" + kolektibilitas + "\",\n" +
                "    \"modal_usaha\": " + modalUsaha + ",\n" +
                "    \"alamat_usaha\": \"" + alamatUsaha + "\",\n" +
                "    \"tanggal_mulai_usaha\": \"" + tanggalMulaiUsaha + "\",\n" +
                "    \"omset_usaha\": " + omsetUsaha + "\n" +
                "}";
    }
}
