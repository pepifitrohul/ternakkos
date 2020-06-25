package com.enigma.ternak.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enigma.ternak.entities.ERole;
import com.enigma.ternak.entities.Roles;

@Repository
public interface RoleRepo extends JpaRepository<Roles, Long>{
	Optional<Roles> findByName (ERole name);
}
