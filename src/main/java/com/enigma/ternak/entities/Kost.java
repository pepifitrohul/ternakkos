package com.enigma.ternak.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kost")
public class Kost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name_kost")
	private String name;
	@Column(name = "category_kost")
	private String category;
	@Column(name = "description")
	private String description;
	@Column(name = "fasilitas")
	private String fasilitas;
	@Column(name = "address")
	private String address;
	@Column(name = "image_url")
	private String imageUrl;
	@Column
	private Double price;
	@Column(name="luas_kamar")
	private String luasKamar;
	@OneToOne(mappedBy = "kost")
	private Location location;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User pemilik;
	
	@OneToMany (mappedBy = "kost", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	private List<Kamar> allKamar;

	public Kost() {

	}

	public Kost(Long id, String name, String category, String description, String fasilitas, String address,
			String imageUrl, Double price, String luasKamar, Location location, User pemilik, List<Kamar> allKamar) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.fasilitas = fasilitas;
		this.address = address;
		this.imageUrl = imageUrl;
		this.price = price;
		this.luasKamar = luasKamar;
		this.location = location;
		this.pemilik = pemilik;
		this.allKamar = allKamar;
	}

	public List<Kamar> getAllKamar() {
		return allKamar;
	}

	public void setAllKamar(List<Kamar> allKamar) {
		this.allKamar = allKamar;
	}

	public String getLuasKamar() {
		return luasKamar;
	}

	public void setLuasKamar(String luasKamar) {
		this.luasKamar = luasKamar;
	}

	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	public String getFasilitas() {
		return fasilitas;
	}

	public String getAddress() {
		return address;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Location getLocation() {
		return location;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFasilitas(String fasilitas) {
		this.fasilitas = fasilitas;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setLocation(Location location) {
		this.location = location;
	}


	public User getPemilik() {
		return pemilik;
	}


	public void setPemilik(User pemilik) {
		this.pemilik = pemilik;
	}

}
