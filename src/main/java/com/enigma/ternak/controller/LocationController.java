package com.enigma.ternak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.ternak.payload.request.LocationDTO;
import com.enigma.ternak.payload.request.LocationRequest;
import com.enigma.ternak.services.LocationServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/location")
public class LocationController {
	
	@Autowired
	LocationServices serv;
	
	@ApiOperation(value = "Add Location to kost")
    @PostMapping("/kost/{kosId}")
    public ResponseEntity<LocationDTO> createKost(@RequestBody LocationRequest request, @PathVariable Long kosId) {
        return ResponseEntity.ok().body(serv.addLocToKos(request, kosId));
    }
	
	@ApiOperation(value = "Get all location of kost")
	@GetMapping("")
	public ResponseEntity<List<LocationDTO>> getAll(){
		return ResponseEntity.ok().body(serv.findAllLoc());
		
	}
	
	@ApiOperation(value = "Find kost location by name kos")
	@GetMapping("/kost/{kosId}")
	public ResponseEntity<LocationDTO> findLocByKosId(@PathVariable Long kosId){
		return ResponseEntity.ok().body(serv.findLocByKosId(kosId));
		
	}
	
	
}
