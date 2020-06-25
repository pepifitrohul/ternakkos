package com.enigma.ternak.exception;

public class StatusOk extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public StatusOk(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
