package com.enigma.ternak.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.enigma.ternak.payload.request.KamarDTO;
import com.enigma.ternak.payload.request.KamarRequest;
import com.enigma.ternak.payload.request.UpdateKamarReq;
import com.enigma.ternak.services.KamarServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;


@Api
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/kamar")
public class KamarController {
	
	@Autowired
	private KamarServices service;
	
	
	@ApiOperation(value = "Get all kamar avaliable")
	@GetMapping("avaliable/kost/{kosId}")
	public ResponseEntity<List<KamarDTO>> getAllKamarByIdKos(@PathVariable Long kosId){
		return ResponseEntity.ok().body(service.findAllKamarByKosId(kosId));
		
	}
	
	
	@ApiOperation(value = "Get all already full kamar")
	@GetMapping("full/kost/{kosId}")
	public ResponseEntity<List<KamarDTO>> getAllKamarFullByIdKos(@PathVariable Long kosId){
		return ResponseEntity.ok().body(service.findAllKamarFullByKosId(kosId));
		
	}
	
	
	
	@GetMapping("/id/{id}")
	@ApiOperation(value = "Get Kamar By Id")
	@ApiResponses(value = {@ApiResponse(code=200,message="Id Found")})
	public ResponseEntity<KamarDTO> findById(@PathVariable Long id) throws NotFoundException{
		return ResponseEntity.ok().body(service.getById(id));
	}
	
	  @GetMapping("/search")
	  @ApiOperation(value = "Get Kamar by name")
	  public KamarDTO getByName(@Valid @RequestParam String name) {
	  return service.getByName(name);
	 }

	@DeleteMapping("/id/{id}")
	@ApiOperation(value = "Delete Kamar by id")
    public void delete(@Valid @PathVariable Long id) {
        service.deleteById(id);
    }
	@DeleteMapping("/{name}")
	@ApiOperation(value = "Delete Kamar by name")
    public void delete(@Valid @PathVariable String name) {
        service.deleteByName(name);
    }
	
	@PostMapping("kosId/{kosId}")		
	@ApiOperation(value = "Create kamar")
	public KamarRequest createKamar(@Valid @RequestBody KamarRequest request, @PathVariable Long kosId ) throws NotFoundException {
		return service.save(kosId, request);
		
	}
	
	@PutMapping("{kamarId}")
	@ApiOperation(value = "Update Kamar")
	public UpdateKamarReq updateKamar(@RequestBody UpdateKamarReq request, @PathVariable Long kamarId) throws NotFoundException {
		return service.update(kamarId, request);
	}
}
