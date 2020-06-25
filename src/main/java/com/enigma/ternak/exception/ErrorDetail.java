package com.enigma.ternak.exception;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;


public class ErrorDetail {
	@ApiModelProperty(notes = "timestamp of error")
	private Date timestamp;

	@ApiModelProperty(notes = "message of error")
	private String message;
	
	@ApiModelProperty(notes = "detail of error")
	private String details;

	public ErrorDetail(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;		
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	

}
