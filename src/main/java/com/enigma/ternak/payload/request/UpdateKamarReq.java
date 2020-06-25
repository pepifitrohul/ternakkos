package com.enigma.ternak.payload.request;


import java.sql.Date;

import javax.validation.constraints.NotEmpty;

public class UpdateKamarReq {
	

	@NotEmpty(message="can't be empty")
	private Date expirationDate;
	
	@NotEmpty(message="can't be empty")
	private String penghuni;
	
	public UpdateKamarReq() {
		super();
	}
	

	public UpdateKamarReq(@NotEmpty(message = "can't be empty") Date expirationDate, String penghuni) {
		super();
		this.expirationDate = expirationDate;
		this.penghuni = penghuni;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}


	public String getPenghuni() {
		return penghuni;
	}


	public void setPenghuni(String penghuni) {
		this.penghuni = penghuni;
	}	
	
	
	
}
