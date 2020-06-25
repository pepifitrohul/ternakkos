package com.enigma.ternak.payload.request;

import java.sql.Date;

public class KamarDTO {
	private Long id;
	private Date expiredDate;
	private String name;
	private int status;
	private String kosName;
	private String penghuni;
	private Long kosId;
	
	public KamarDTO() {
		super();
	}

	
	public KamarDTO(Long id, Date expiredDate, String name, int status) {
		super();
		this.id = id;
		this.expiredDate = expiredDate;
		this.name = name;
		this.status = status;
	}


	public KamarDTO(Long id, Date expiredDate, String name, int status, String kosName,
			String penghuni, Long kosId) {
		super();
		this.id = id;
		this.expiredDate = expiredDate;
		this.name = name;
		this.status = status;
		this.kosName = kosName;
		this.penghuni = penghuni;
		this.kosId = kosId;
	}
	
	


	public Long getKosId() {
		return kosId;
	}

	public void setKosId(Long kosId) {
		this.kosId = kosId;
	}

	public String getKosName() {
		return kosName;
	}

	public void setKosName(String kosName) {
		this.kosName = kosName;
	}

	public String getPenghuni() {
		return penghuni;
	}

	public void setPenghuni(String penghuni) {
		this.penghuni = penghuni;
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

	public int isStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public int getStatus() {
		return status;
	}
	
		
}
