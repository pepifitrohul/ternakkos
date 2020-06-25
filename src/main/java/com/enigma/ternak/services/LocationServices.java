package com.enigma.ternak.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enigma.ternak.entities.Kost;
import com.enigma.ternak.entities.Location;
import com.enigma.ternak.payload.request.LocationDTO;
import com.enigma.ternak.payload.request.LocationRequest;
import com.enigma.ternak.repository.LocationRepo;

@Service
public class LocationServices {

	@Autowired
	LocationRepo repo;
	
	@Autowired
	KostServices kosServ;
	
	public Location convertLocation(LocationDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Location location = modelMapper.map(dto, Location.class);
        return location;
    }

    public LocationDTO convertLocationDto(Location location) {
        ModelMapper modelMapper = new ModelMapper();
        LocationDTO dto = modelMapper.map(location, LocationDTO.class);
        dto.setNameKos(location.getKost().getName());
        return dto;
    }
    
    public LocationDTO addLocToKos(LocationRequest req, Long kosId) {
    	 Optional<Kost> kos = kosServ.getByID(kosId);
    	 ModelMapper modelMapper = new ModelMapper();
         Location location = modelMapper.map(req, Location.class);
         location.setKost(kos.get());
         repo.save(location);
         return convertLocationDto(location);
    }
    
    public LocationDTO findLocByKosId (Long kosId) {
    	Location loc = repo.findByKostId(kosId);
    	return convertLocationDto(loc);
    }
    
    
    public List<Location> getAll(){
    	return repo.findAll();
    }
    
    
	public List<LocationDTO> convertListLocationToListDTO(List<Location> allLoc){
		ModelMapper mapper = new ModelMapper();
		List<LocationDTO> listDTO = Arrays.asList(mapper.map(allLoc, LocationDTO[].class));
		for (LocationDTO locDTO : listDTO) {
			for (Location loc : allLoc) {
				if(locDTO.getNameLocation().equals(loc.getNameLocation())) {
					locDTO.setNameKos(loc.getKost().getName());
					
				}
			}
		}
		return listDTO;

	}
    
	
	public List<LocationDTO> findAllLoc(){
		List <Location> allLoc = repo.findAll();
		return this.convertListLocationToListDTO(allLoc);
	}
	
    
    public Location getByID(Long id){
    	return repo.findLocationById(id);
    }
    
	public LocationDTO getByName(String name) {
		Location location = repo.findLocationByNameLocation(name);
		return convertLocationDto(location);
	}
	
	public void deleteById (Long id) {
		repo.deleteById(id);
	}
}
