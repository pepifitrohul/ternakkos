package com.enigma.ternak.payload.request;

import javax.validation.constraints.NotEmpty;

public class KostRequest {
	@NotEmpty(message="kos name can't be empty")
	private String name;
	@NotEmpty(message="kos category can't be empty")
	private String category;
	@NotEmpty(message="kos description can't be empty")
	private String description;
	@NotEmpty(message="kos failistas can't be empty")
	private String fasilitas;
	@NotEmpty(message="kos address can't be empty")
	private String address;
	@NotEmpty(message="kos imageUrl can't be empty")
	private String imageUrl;
	@NotEmpty(message="kos price can't be empty")
	private Double price;
	@NotEmpty(message="kos luas kamar can't be empty")
	private String luasKamar;
	@NotEmpty(message="kos imageUrl can't be empty")
	private String pemilik;
	
	public KostRequest() {
		// TODO Auto-generated constructor stub
	}

	
	public KostRequest(@NotEmpty(message = "kos name can't be empty") String name,
			@NotEmpty(message = "kos category can't be empty") String category,
			@NotEmpty(message = "kos description can't be empty") String description,
			@NotEmpty(message = "kos failistas can't be empty") String fasilitas,
			@NotEmpty(message = "kos address can't be empty") String address,
			@NotEmpty(message = "kos imageUrl can't be empty") String imageUrl,
			@NotEmpty(message = "kos price can't be empty") Double price,
			@NotEmpty(message = "kos luas kamar can't be empty") String luasKamar,
			@NotEmpty(message = "kos imageUrl can't be empty") String pemilik) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
		this.fasilitas = fasilitas;
		this.address = address;
		this.imageUrl = imageUrl;
		this.price = price;
		this.luasKamar = luasKamar;
		this.pemilik = pemilik;
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


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getLuasKamar() {
		return luasKamar;
	}


	public void setLuasKamar(String luasKamar) {
		this.luasKamar = luasKamar;
	}


	public String getPemilik() {
		return pemilik;
	}


	public void setPemilik(String pemilik) {
		this.pemilik = pemilik;
	}
	
	
	
}
