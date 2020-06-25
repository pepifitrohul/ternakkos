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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.ternak.payload.request.KostDTO;
import com.enigma.ternak.payload.request.KostRequest;
import com.enigma.ternak.services.KostServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/kost")
public class KostController {

	@Autowired
	KostServices serv;
	
	@ApiOperation(value = "Create kost")
    @PostMapping("")
    public ResponseEntity<KostRequest> createKost(@RequestBody KostRequest request) {
        return ResponseEntity.ok().body(serv.createKost(request));
    }
	
	@ApiOperation(value = "Get all kost")
	@GetMapping("")
	public ResponseEntity<List<KostDTO>> findAllKos(){
		return ResponseEntity.ok().body(serv.findAllKos());
		
	}
	
	@ApiOperation(value = "search kost by name")
	@GetMapping("/search/{name}")
	public ResponseEntity<List<KostDTO>> findAllKosByName(@PathVariable String name){
		return ResponseEntity.ok().body(serv.searchAllKosByName(name));
		
	}
	
	
	@ApiOperation(value = "Get all kost by category")
	@GetMapping("/category/{category}")
	public ResponseEntity<List<KostDTO>> findAllKosByCategory(@RequestParam String category){
		return ResponseEntity.ok().body(serv.findAllKosByCategory(category));
		
	}
	
	@ApiOperation(value = "filter kost by price range")
	@GetMapping("/{minPrice}/{maxPrice}")
	public ResponseEntity<List<KostDTO>> filterByPriceRang(@PathVariable Double minPrice, @PathVariable Double maxPrice){
		return ResponseEntity.ok().body(serv.filterKosBasedOnPrice(minPrice, maxPrice));
		
	}
	
	@ApiOperation(value = "Get all kost by category")
	@GetMapping("/kosId/{kosId}")
	public ResponseEntity<KostDTO> findKosById(@PathVariable Long kosId){
		return ResponseEntity.ok().body(serv.findKosById(kosId));
		
	}
	
	
	
	
	
}