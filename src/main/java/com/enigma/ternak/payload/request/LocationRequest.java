package com.enigma.ternak.payload.request;

public class LocationRequest {
	private String nameLocation;
	private String latitude;
	private String longitude;
	
	public LocationRequest() {
		// TODO Auto-generated constructor stub
	}

	public LocationRequest(String nameLocation, String latitude, String longitude) {
		super();
		this.nameLocation = nameLocation;
		this.latitude = latitude;
		this.longitude = longitude;
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
