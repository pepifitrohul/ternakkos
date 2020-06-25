package com.enigma.ternak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.ternak.entities.Kost;

public interface KostRepo extends JpaRepository<Kost, Long>{
	List<Kost>findKostByName(String name);
	List<Kost> findKostByPrice(Double price);
	List<Kost> findKostByCategory(String category);
	List<Kost> findByNameContainsIgnoreCase(String name);
}
