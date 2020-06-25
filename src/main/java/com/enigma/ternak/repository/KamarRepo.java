package com.enigma.ternak.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.ternak.entities.Kamar;
import com.enigma.ternak.payload.request.KamarRequest;

public interface KamarRepo extends JpaRepository<Kamar, Long> {
	Kamar findKamarByName (String name);
	void deleteByName(String name);
	KamarRequest save(@Valid KamarRequest request);
}
