package com.enigma.ternak.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enigma.ternak.entities.Kamar;
import com.enigma.ternak.entities.Kost;
import com.enigma.ternak.entities.User;
import com.enigma.ternak.payload.request.KamarDTO;
import com.enigma.ternak.payload.request.KamarRequest;
import com.enigma.ternak.payload.request.UpdateKamarReq;
import com.enigma.ternak.repository.KamarRepo;
import com.enigma.ternak.repository.KostRepo;
import com.enigma.ternak.repository.UserRepo;

import javassist.NotFoundException;

@Service
public class KamarServices {

	@Autowired
	KamarRepo kamarRepo;
	
	@Autowired
	KostRepo kostRepo;
	
	@Autowired
	UserRepo userRepo;
	
	
	public Kamar saveKamar (Kamar kmr) {
		return kamarRepo.save(kmr);
	}
	
	public Kamar convertKamar(KamarDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		Kamar kamar = modelMapper.map(dto, Kamar.class);
		return kamar;
	}
	
	public KamarDTO convertkamarDto(Kamar kamar) {
		ModelMapper modelMapepr = new ModelMapper();
		KamarDTO dto = modelMapepr.map(kamar, KamarDTO.class);
		dto.setKosName(kamar.getKost().getName());
		dto.setKosId(kamar.getKost().getId());
		return dto;
	}
	
	public List<Kamar> getAll(){
		return kamarRepo.findAll();
	}
	
	public List<KamarDTO> convertListKamarToListDTO(List<Kamar> allKamar){
		ModelMapper mapper = new ModelMapper();
		List<KamarDTO> listDTO = Arrays.asList(mapper.map(allKamar, KamarDTO[].class));
		for (KamarDTO kamarDTO : listDTO) {
			for (Kamar kamar : allKamar) {
				if(kamarDTO.getId().equals(kamar.getId())) {
					kamarDTO.setKosName(kamar.getKost().getName());
					kamarDTO.setKosId(kamar.getKost().getId());
				}
			}
		}
		return listDTO;

	}
	
	
	public List<KamarDTO> findAllKamarByKosId(Long kosId){
		List<KamarDTO> allKamar = this.findAllKamarAvaliable();
		List <KamarDTO> filteredAllKamar = allKamar.stream().filter(kamar -> kosId==kamar.getKosId()).collect(Collectors.toList());
		return filteredAllKamar;
	}
	
	
	public List<KamarDTO> findAllKamarFullByKosId(Long kosId){
		List<KamarDTO> allKamar = this.findAllKamarAlreadyFull();
		List <KamarDTO> filteredAllKamar = allKamar.stream().filter(kamar -> kosId==kamar.getKosId()).collect(Collectors.toList());
		return filteredAllKamar;
	}
	
	public List<KamarDTO> findAllKamar(){
		List <Kamar> allKamar = kamarRepo.findAll();
		return this.convertListKamarToListDTO(allKamar);
	}
	
	
	public List<KamarDTO> findAllKamarAlreadyFull (){
		List <Kamar> allKamar = kamarRepo.findAll();
		List <Kamar> filteredAllKamar = allKamar.stream().filter(kamar -> kamar.getStatus()==1).collect(Collectors.toList());
		return this.convertListKamarToListDTO(filteredAllKamar);
	}
	
	
	public List<KamarDTO> findAllKamarAvaliable (){
		List <Kamar> allKamar = kamarRepo.findAll();
		List <Kamar> filteredAllKamar = allKamar.stream().filter(kamar -> kamar.getStatus()==0).collect(Collectors.toList());
		return this.convertListKamarToListDTO(filteredAllKamar);
	}
	
	public KamarDTO getById(Long id) throws NotFoundException {
		Kamar kamar = kamarRepo.findById(id).orElseThrow(()->new NotFoundException(id+" is not found"));
		ModelMapper modelMapper= new ModelMapper();
		KamarDTO dto= modelMapper.map(kamar, KamarDTO.class);
				return dto;
	}
	public KamarDTO getByName(String name) {
		Kamar kamar = kamarRepo.findKamarByName(name);
		return convertkamarDto(kamar);
	}
	
	public void deleteById (Long id) {
		kamarRepo.deleteById(id);
	}
	
	public void deleteByName(String name) {
		kamarRepo.deleteByName(name);
	}

	public KamarRequest save(Long kosId, KamarRequest request) throws NotFoundException {
		Optional<Kost> kost = kostRepo.findById(kosId);
		Kamar kmr = new Kamar();
		kmr.setName(request.getName());;
		kmr.setStatus(0);
		kmr.setKost(kost.get());
		kamarRepo.save(kmr);
		return request;
		
	}
	
	public UpdateKamarReq update(Long kamarId, UpdateKamarReq request) throws NotFoundException {
		Optional<Kamar> kmr = kamarRepo.findById(kamarId);
    	if(kmr.isPresent()) throw new NotFoundException("Username is Not Found");
		Optional<User> penghuni = userRepo.findByUsername(request.getPenghuni());
		kmr.get().setExpiredDate(request.getExpirationDate());
		kmr.get().setStatus(1);
		kmr.get().setPenghuni(penghuni.get());
		kamarRepo.save(kmr.get());;
		return request;
		
	}
	
	 public Optional<Kamar> findById(Long id){
			return kamarRepo.findById(id);	
	    }
	
}
