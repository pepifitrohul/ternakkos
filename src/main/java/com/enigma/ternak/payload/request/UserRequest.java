package com.enigma.ternak.payload.request;

import java.util.Set;

public class UserRequest {

	private String username;
	private String email;
	private String password;
	private Set<String> role;
	private String gender;
	private String numberHp;
	
	public UserRequest() {
		
	}

	public UserRequest(String username, String email, String password, Set<String> role, String gender, String numberHp) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.gender = gender;
		this.numberHp = numberHp;
	}
	
	


	public UserRequest(String username, String email, String password, String gender, String numberHp) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.numberHp = numberHp;
	}

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Set<String> getRole() {
		return role;
	}



	public void setRole(Set<String> role) {
		this.role = role;
	}



	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNumberHp() {
		return numberHp;
	}

	public void setNumberHp(String numberHp) {
		this.numberHp = numberHp;
	}

	

	
}
