package com.enigma.ternak.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enigma.ternak.entities.Kamar;
import com.enigma.ternak.entities.Transaction;
import com.enigma.ternak.entities.User;
import com.enigma.ternak.exception.BadRequest;
import com.enigma.ternak.payload.request.TransactionDTO;
import com.enigma.ternak.payload.request.TransactionRequest;
import com.enigma.ternak.repository.TransactionRepo;

@Service
public class TransactionService {

	@Autowired
	TransactionRepo repo;
	
	@Autowired
	UserServices userServ;
	
	@Autowired
	KamarServices kamarServ;
	
	public Transaction convertTransaction(TransactionDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		Transaction trsc = modelMapper.map(dto, Transaction.class);
		return trsc;
	}
	
	public TransactionDTO convertTransactionDto(Transaction trsc) {
		ModelMapper modelMapepr = new ModelMapper();
		TransactionDTO dto = modelMapepr.map(trsc, TransactionDTO.class);
		dto.setPemilikName(trsc.getUserPemilik().getUsername());
		dto.setPencariName(trsc.getUserPencari().getUsername());
		dto.setKamarName(trsc.getKamar().getName());
		dto.setKosName(trsc.getKamar().getKost().getName());
		return dto;
	}
	
	
    public List<Transaction> getAll(){
    	return repo.findAll();
    }
    
    
	public List<TransactionDTO> convertTransactionToListDTO(List<Transaction> transactions){
		ModelMapper mapper = new ModelMapper();
		List<TransactionDTO> listDTO = Arrays.asList(mapper.map(transactions, TransactionDTO[].class));
		for (TransactionDTO transactionDTO : listDTO) {
			for (Transaction transaction : transactions) {
				if(transactionDTO.getId().equals(transaction.getId())) {
					transactionDTO.setPemilikName(transaction.getUserPemilik().getUsername());
					transactionDTO.setPencariName(transaction.getUserPencari().getUsername());
					transactionDTO.setKamarName(transaction.getKamar().getName());
					transactionDTO.setKosName(transaction.getKamar().getKost().getName());
					
				}
			}
		}
		return listDTO;

	}
	
	
	public List<TransactionDTO> findAllTransaction(){
		List <Transaction> transactions = repo.findAll();
		return this.convertTransactionToListDTO(transactions);
	}
	
	
	public List<TransactionDTO> findAllTransactionToPemilik (String pemilikName){
		List<Transaction> transactions = repo.findByStatusAndUserPemilikUsername(0, pemilikName);
		return this.convertTransactionToListDTO(transactions);
	}
	
	
	public TransactionDTO findBookByPencari(String pencariName){
		Transaction transaction = repo.findByUserPencariUsername(pencariName);
		return this.convertTransactionDto(transaction);
	}
	
	
	 @SuppressWarnings("unlikely-arg-type")
	public TransactionRequest booking(TransactionRequest book) {
		 User pencari = userServ.findUserByUsername(book.getPencariName());
		 Optional<Kamar> kamar = kamarServ.findById(book.getKamarId());
		 User pemilik = userServ.findUserByUsername(book.getPemilikName());
		 List <Transaction> transactions = repo.findAll();
		 if(transactions.contains(kamar.get())&& transactions.contains(pencari)) {
			 throw new BadRequest("booking already wait for approval");
		 }
		 kamar.get().setStatus(1);
		 kamarServ.saveKamar(kamar.get());
		 Transaction trans = new Transaction();
		 long millis=System.currentTimeMillis();  
		 java.sql.Date date=new java.sql.Date(millis);
		 userServ.update(pencari);
		 trans.setTransactionDate(date);
		 trans.setDurasi(book.getDurasi());
		 trans.setUserPencari(pencari);
		 trans.setUserPemilik(pemilik);
		 trans.setTanggalMasuk(book.getTanggalMasuk());
		 trans.setKamar(kamar.get());
		 repo.save(trans);
		 return book;   
			
	 }
}
