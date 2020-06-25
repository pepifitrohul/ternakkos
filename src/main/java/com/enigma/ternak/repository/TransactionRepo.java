package com.enigma.ternak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.ternak.entities.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
	Transaction findByUserPencariUsername (String pencariName);
	List<Transaction> findByStatusAndUserPemilikUsername(int status, String pemilikName);
}
