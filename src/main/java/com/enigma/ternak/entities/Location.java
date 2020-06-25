package com.enigma.ternak.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name_location")
	private String nameLocation;
	@Column
	private String latitude;
	@Column
	private String longitude;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "kost_id", referencedColumnName = "id")
	private Kost kost;
	public Location() {
		// TODO Auto-generated constructor stub
	}
	

	public Location(String nameLocation, String latitude, String longitude) {
		super();
		this.nameLocation = nameLocation;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public Location(Long id, String nameLocation, String latitude, String longitude) {
		super();
		this.id = id;
		this.nameLocation = nameLocation;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Location(Long id, String nameLocation, String latitude, String longitude, Kost kost) {
		super();
		this.id = id;
		this.nameLocation = nameLocation;
		this.latitude = latitude;
		this.longitude = longitude;
		this.kost = kost;
	}

	public Location(String name, String latitude, String longitude, Kost kost) {
		super();
		this.nameLocation = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.kost = kost;
	}

	public Kost getKost() {
		return kost;
	}

	public void setKost(Kost kost) {
		this.kost = kost;
	}

	public Long getId() {
		return id;
	}

	public String getNameLocation() {
		return nameLocation;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNameLocation(String name) {
		this.nameLocation = name;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
	
}
