package com.enigma.ternak.payload.request;

import java.sql.Date;

import javax.validation.constraints.NotBlank;



public class TransactionRequest {
	private Date tanggalMasuk;
	@javax.validation.constraints.NotBlank(message = "cannot be empty")
	private String durasi;
	private Long kamarId;
	private String pemilikName;
	private String pencariName;
	
	
	public TransactionRequest() {
		
	}

	public TransactionRequest(Date tanggalMasuk, @NotBlank(message = "cannot be empty") String durasi, Long kamarId,
			String pemilikName, String pencariName) {
		super();
		this.tanggalMasuk = tanggalMasuk;
		this.durasi = durasi;
		this.kamarId = kamarId;
		this.pemilikName = pemilikName;
		this.pencariName = pencariName;
	}






	public Date getTanggalMasuk() {
		return tanggalMasuk;
	}
	public void setTanggalMasuk(Date tanggalMasuk) {
		this.tanggalMasuk = tanggalMasuk;
	}
	public String getDurasi() {
		return durasi;
	}
	public void setDurasi(String durasi) {
		this.durasi = durasi;
	}
	public Long getKamarId() {
		return kamarId;
	}
	public void setKamarId(Long kamarId) {
		this.kamarId = kamarId;
	}
	
	
	public String getPemilikName() {
		return pemilikName;
	}

	public void setPemilikName(String pemilikName) {
		this.pemilikName = pemilikName;
	}

	public String getPencariName() {
		return pencariName;
	}

	public void setPencariName(String pencariName) {
		this.pencariName = pencariName;
	}


}
