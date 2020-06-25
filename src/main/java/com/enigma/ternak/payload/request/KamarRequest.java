package com.enigma.ternak.payload.request;

import javax.validation.constraints.NotEmpty;

public class KamarRequest {
	

	@NotEmpty(message="kamar name can't be empty")
	private String name;;
	
	public KamarRequest() {
		super();
	}
	
	public KamarRequest(@NotEmpty(message = "kamar name can't be empty") String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
