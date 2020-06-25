package com.enigma.ternak.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enigma.ternak.entities.Kost;
import com.enigma.ternak.entities.User;
import com.enigma.ternak.payload.request.KostDTO;
import com.enigma.ternak.payload.request.KostRequest;
import com.enigma.ternak.repository.KostRepo;
import com.enigma.ternak.repository.UserRepo;

@Service
public class KostServices {
	
	@Autowired
	KostRepo repo;
	
	@Autowired
	KamarServices kamarServ;
	
	@Autowired
	UserRepo userRepo;
	
	public Kost convertKost(KostDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Kost kost = modelMapper.map(dto, Kost.class);
        return kost;
    }

    public KostDTO convertKostDto(Kost kos) {
        ModelMapper modelMapper = new ModelMapper();
        KostDTO dto = modelMapper.map(kos, KostDTO.class);
    	dto.setPemilik(kos.getPemilik().getUsername());
		dto.setJumlahKamar(kos.getAllKamar().size());
		dto.setKontakPemilik(kos.getPemilik().getNumberHp());
        return dto;
    }
    
    
    public KostDTO findKosById (Long kosId) {
    	Optional<Kost> kos = repo.findById(kosId);
    	return convertKostDto(kos.get());
    }
    
    public KostRequest createKost(KostRequest req) {
    	 ModelMapper modelMapper = new ModelMapper();
         Kost kost = modelMapper.map(req, Kost.class);
         Optional<User> owner = userRepo.findByUsername(req.getPemilik());
         kost.setPemilik(owner.get());
         repo.save(kost);
         return req;
    }
    
    public List<Kost> getAll(){
    	return repo.findAll();
    }
    
    public List<KostDTO> convertListKostToListDTO(List<Kost> allKos){
    	ModelMapper mapper = new ModelMapper();
		List<KostDTO> listDTO = Arrays.asList(mapper.map(allKos, KostDTO[].class));
		for (KostDTO kosDTO : listDTO) {
			for (Kost kos : allKos) {
				if(kosDTO.getName().equals(kos.getName())) {
					kosDTO.setPemilik(kos.getPemilik().getUsername());
					kosDTO.setJumlahKamar(kos.getAllKamar().size());
					kosDTO.setKontakPemilik(kos.getPemilik().getNumberHp());
					
				}
			}
		}
		return listDTO;
    }
    
    
	public List<KostDTO> findAllKos(){
		List <Kost> allKos = repo.findAll();
		return this.convertListKostToListDTO(allKos);
	}
    
	public List<KostDTO> findAllKosByCategory(String category){
		List <Kost> allKos = repo.findKostByCategory(category);
		return this.convertListKostToListDTO(allKos);
	}
	
	public List<KostDTO> findAllKosByName(String name){
		List <Kost> allKos = repo.findKostByName(name);
		return this.convertListKostToListDTO(allKos);
	}
	
	public List<KostDTO> searchAllKosByName(String name){
		List <Kost> allKos = repo.findByNameContainsIgnoreCase(name);
		return this.convertListKostToListDTO(allKos);
	}
    
	
	public List<KostDTO> filterKosBasedOnPrice(Double minPrice, Double maxPrice){
		List<Kost> allKos = repo.findAll();
		List<Kost> filteredAllKos = new ArrayList<Kost>();
		for (Kost kost : allKos) {
			if(kost.getPrice()>= minPrice && kost.getPrice()<= maxPrice) {
				filteredAllKos.add(kost);
			}
		}
		return this.convertListKostToListDTO(filteredAllKos);
	}

	
	
    public Optional<Kost> getByID(Long id){
    	return repo.findById(id);
    }

	
	public void deleteById (Long id) {
		repo.deleteById(id);
	}

}