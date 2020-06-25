package com.enigma.ternak.payload.request;

import java.sql.Date;

public class TransactionDTO {
	private Long id;
	private Date transactionDate;
	private Date tanggalMasuk;
	private String durasi;
	private String kamarName;
	private String KosName;
	private String pemilikName;
	private String pencariName;
	private int status;
	
	public TransactionDTO() {
		
	}

	public TransactionDTO(Long id, Date transactionDate, Date tanggalMasuk, String durasi, String kamarName,
			String kosName, String pemilikName, String pencariName, int status) {
		super();
		this.id = id;
		this.transactionDate = transactionDate;
		this.tanggalMasuk = tanggalMasuk;
		this.durasi = durasi;
		this.kamarName = kamarName;
		KosName = kosName;
		this.pemilikName = pemilikName;
		this.pencariName = pencariName;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getKamarName() {
		return kamarName;
	}

	public void setKamarName(String kamarName) {
		this.kamarName = kamarName;
	}

	public String getKosName() {
		return KosName;
	}

	public void setKosName(String kosName) {
		KosName = kosName;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
	

}
