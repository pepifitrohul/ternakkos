package com.enigma.ternak.payload.request;

public class LocationDTO {
	private Long id;
	private String nameLocation;
	private String latitude;
	private String longitude;
    private String nameKos;
	
	public LocationDTO() {
		// TODO Auto-generated constructor stub
	}

	

	public LocationDTO(String nameLocation, String latitude, String longitude, String nameKos) {
		super();
		this.nameLocation = nameLocation;
		this.latitude = latitude;
		this.longitude = longitude;
		this.nameKos = nameKos;
	}



	public LocationDTO(Long id, String nameLocation, String latitude, String longitude, String nameKos) {
		super();
		this.id = id;
		this.nameLocation = nameLocation;
		this.latitude = latitude;
		this.longitude = longitude;
		this.nameKos = nameKos;
	}


	public String getNameKos() {
		return nameKos;
	}

	public void setNameKos(String nameKos) {
		this.nameKos = nameKos;
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

	public void setNameLocation(String nameLocation) {
		this.nameLocation = nameLocation;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
}
