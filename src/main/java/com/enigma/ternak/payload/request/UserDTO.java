package com.enigma.ternak.payload.request;


import java.util.Set;

public class UserDTO {
	private Long id;
	private String username;
	private String email;
	private Set<String> role;
	private String gender;
	private String numberHp;
	
	public UserDTO() {
	}


	public UserDTO(Long id, String username, String email, String password, Set<String> role, String gender, String numberHp) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.role = role;
		this.gender = gender;
		this.numberHp = numberHp;
	}
	
	



	public UserDTO(String username, String email, String gender, String numberHp) {
		super();
		this.username = username;
		this.email = email;
		this.gender = gender;
		this.numberHp = numberHp;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
