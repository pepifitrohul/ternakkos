package com.enigma.ternak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigma.ternak.entities.Location;

public interface LocationRepo extends JpaRepository<Location, Long> {
	Location findLocationByNameLocation(String name);
	Location findByKostId(Long kosId);
	Location findLocationByKostName(String name);
	Location findLocationById(Long id);
}
