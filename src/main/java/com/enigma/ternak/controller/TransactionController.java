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

import com.enigma.ternak.payload.request.TransactionDTO;
import com.enigma.ternak.payload.request.TransactionRequest;
import com.enigma.ternak.services.TransactionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService serv;
	
	@ApiOperation(value = "Create Transaction")
    @PostMapping("")
    public ResponseEntity<TransactionRequest> createKost(@RequestBody TransactionRequest req) {
        return ResponseEntity.ok().body(serv.booking(req));
    }
	
	@ApiOperation(value = "Get Requst Booking To Pemilik")
    @GetMapping("/pemilik/{pemilikName}")
    public ResponseEntity<List<TransactionDTO>> getListBookingRequset(@PathVariable String pemilikName) {
        return ResponseEntity.ok().body(serv.findAllTransactionToPemilik(pemilikName));
    }

	@ApiOperation(value = "Get Booking  from Pencari")
    @GetMapping("/pencari/{pencariName}")
    public ResponseEntity<TransactionDTO> getBooking(@PathVariable String pencariName) {
        return ResponseEntity.ok().body(serv.findBookByPencari(pencariName));
    }
	
}