package com.enigma.ternak.payload.request;

public class KostDTO {	
	private Long id;
	private String name;
	private String category;
	private String description;
	private String fasilitas;
	private String address;
	private String imageUrl;
	private Double price;
	private String luasKamar;
	private String pemilik;
	private Integer jumlahKamar;
	private String kontakPemilik;
	
	public KostDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public KostDTO(Long id, String name, String category, String description, String fasilitas, String address,
			String imageUrl, Double price, String luasKamar, String pemilik, Integer jumlahKamar, String kontakPemilik) {
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
		this.pemilik = pemilik;
		this.jumlahKamar = jumlahKamar;
		this.kontakPemilik = kontakPemilik;
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


	public void setPemilik(String string) {
		this.pemilik = string;
	}

	

	public Integer getJumlahKamar() {
		return jumlahKamar;
	}


	public void setJumlahKamar(Integer jumlahKamar) {
		this.jumlahKamar = jumlahKamar;
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


	public String getKontakPemilik() {
		return kontakPemilik;
	}


	public void setKontakPemilik(String kontakPemilik) {
		this.kontakPemilik = kontakPemilik;
	}
	
	
	
	
	
}
