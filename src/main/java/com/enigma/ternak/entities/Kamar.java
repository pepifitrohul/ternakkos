package com.enigma.ternak.entities;

import java.sql.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="kamar")
public class Kamar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "name_kamar")
	private String name;
	
	
	@Column(name = "expired_date", nullable = true)
	private Date expiredDate;
	
	@Column
	private int status;
	
	@ManyToOne
	@JoinColumn(name="kost_id")
	private Kost kost;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User penghuni;

	
	public Kamar() {
		// TODO Auto-generated constructor stub
	}
	
	public Kamar(Long id, String name, Date expiredDate, int status) {
		super();
		this.id = id;
		this.name = name;
		this.expiredDate = expiredDate;
		this.status = status;
	}




	public Kamar(String name, Date expiredDate, int status, Kost kost, User penghuni) {
		super();
		this.name = name;
		this.expiredDate = expiredDate;
		this.status = status;
		this.kost = kost;
		this.penghuni = penghuni;
	}


	public Date getExpiredDate() {
		return expiredDate;
	}


	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Kost getKost() {
		return kost;
	}


	public void setKost(Kost kost) {
		this.kost = kost;
	}

	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public User getPenghuni() {
		return penghuni;
	}


	public void setPenghuni(User penghuni) {
		this.penghuni = penghuni;
	}
	
	


}