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
@Table(name="booking_transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "transaction_date")
	private Date transactionDate;
	
	@Column(name = "tanggal_masuk")
	private Date tanggalMasuk;
	
	@Column(name = "durasi")
	private String durasi;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "kamar_id", referencedColumnName = "id")
	private Kamar kamar;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pemilik", referencedColumnName = "id")
	private User userPemilik;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pencari", referencedColumnName = "id")
	private User userPencari;
;
	
	@Column
	private int status;
	
	
	public Transaction() {
		
	}

	public Transaction(Long id, Date transactionDate, Date tanggalMasuk, String durasi, Kamar kamar, User userPemilik,
			User userPencari, int status) {
		super();
		this.id = id;
		this.transactionDate = transactionDate;
		this.tanggalMasuk = tanggalMasuk;
		this.durasi = durasi;
		this.kamar = kamar;
		this.userPemilik = userPemilik;
		this.userPencari = userPencari;
		this.status = status;
	}

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Date getTanggalMasuk() {
		return tanggalMasuk;
	}

	public void setTanggalMasuk(Date tanggalMasuk) {
		this.tanggalMasuk = tanggalMasuk;
	}

	public String getDurasi() {
		return durasi;
	}

	public void setDurasi(String durasi) {
		this.durasi = durasi;
	}

	public Kamar getKamar() {
		return kamar;
	}

	public void setKamar(Kamar kamar) {
		this.kamar = kamar;
	}

	public User getUserPemilik() {
		return userPemilik;
	}

	public void setUserPemilik(User userPemilik) {
		this.userPemilik = userPemilik;
	}

	public User getUserPencari() {
		return userPencari;
	}

	public void setUserPencari(User userPencari) {
		this.userPencari = userPencari;
	}
	
	
	
	
}