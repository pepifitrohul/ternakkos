package com.enigma.ternak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.ternak.entities.User;
import com.enigma.ternak.services.UserServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserServices serv;
	

	@GetMapping("")
	@ApiOperation(value = "Get All User")
	@ApiResponses(value = {@ApiResponse(code=200,message="Id Found")})
	public ResponseEntity<List<User>>findAll(){
		return ResponseEntity.ok().body(serv.getAll());
		
	}
	
}
