package com.enigma.ternak;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


import com.enigma.ternak.entities.Kost;
import com.enigma.ternak.entities.Location;
import com.enigma.ternak.exception.NotFoundException;
import com.enigma.ternak.payload.request.LocationDTO;
import com.enigma.ternak.payload.request.LocationRequest;
import com.enigma.ternak.repository.KostRepo;
import com.enigma.ternak.repository.LocationRepo;
import com.enigma.ternak.repository.RoleRepo;
import com.enigma.ternak.repository.UserRepo;
import com.enigma.ternak.services.KostServices;
import com.enigma.ternak.services.LocationServices;


@RunWith(SpringRunner.class)
public class LocationServicesTest {
	public LocationServicesTest() {
		// TODO Auto-generated constructor stub
	}
	@TestConfiguration
	static class LocationServicesTestContextConfiguration{
		@Bean
		public LocationServices locationServices() {
			return new LocationServices();
		}

	}
	@Autowired
	private LocationServices serviceLoc;
	
	@MockBean
	private KostServices kosServ;

	@MockBean
	private LocationRepo repoLoc;
	
	@MockBean
	private KostRepo kostRepo;
	
	@MockBean
	private UserRepo userRepo;
	
	@MockBean
	private PasswordEncoder encoder;
	
	@MockBean
	private RoleRepo roleRepository;

	@Before
	public void setup(){

		Location locationId = new Location(1L, "Melati", "-6.301612", "106.819964");
		Location location = new Location("Melati", "-6.301612", "106.819964");
		LocationDTO locationDTO = new LocationDTO("Melati", "-6.301612", "106.819964", "Melatia");
		LocationRequest locationreq = new LocationRequest("Melati", "-6.301612", "106.819964");
		List<Location> listLocation = new ArrayList<Location>();
		listLocation.add(location);
		
		Mockito.when(repoLoc.save(location)).thenReturn(location);
		Mockito.when(serviceLoc.getByID(locationId.getId())).thenReturn(location);
		Mockito.when(repoLoc.findLocationById(location.getId())).thenReturn(location);
		Mockito.when(repoLoc.findAll()).thenReturn(listLocation);
		Mockito.when(repoLoc.findLocationByNameLocation("Melati")).thenReturn(location);
		Mockito.when(repoLoc.findLocationByKostName("Melati")).thenReturn(location);
	
	}

	@Test
	public void whenGetAll_returnListLocation() {
		assertEquals(serviceLoc.getAll().size(), 1);
	}
	
	@Test
	public void whenGetAllbyName_returnListLocation() throws NotFoundException {
		List<LocationDTO> a = serviceLoc.findAllLoc();
		assertEquals(a.size(), 1);
	}
	
	
	@Test
	public void whenFindById_returnLocation() {
		Location loc = serviceLoc.getByID((long)1);
		assertEquals(loc.getNameLocation(), "Melati");
	}
	
	@Test
	public void whenGetByName_returnLocationDto() {
		Location loc = repoLoc.findLocationByNameLocation("Melati");
		LocationDTO locationDTO = new LocationDTO("Melati", "-6.301612", "106.819964", "Melatia");
		serviceLoc.convertLocation(locationDTO);
		assertEquals(loc.getNameLocation(),"Melati");
	}
	
	@Test
	public void whenDelete_thenLocationDelete() {
		Location loc = repoLoc.findLocationById((long)1);
		serviceLoc.deleteById(loc.getId());
	}
	
	@Test
	public void whenFindByNameKos_thenReturnLocDto() {
		Location loc = repoLoc.findLocationByKostName("Melatia");
		
	}
	
	@Test
	public void whenCreateLocation_thenReturnLocationDto() {
		 Optional<Kost> kos = kosServ.getByID((long)1);
 		 LocationRequest locationreq = new LocationRequest("Melati", "-6", "106.819964");
    	 ModelMapper modelMapper = new ModelMapper();
         Location location = modelMapper.map(locationreq, Location.class);
         repoLoc.save(location);
//         location.setKost(kos.get());
         assertEquals(serviceLoc.addLocToKos(locationreq, ((long)1)), location);;

	}
	
	@Test
	public void whenFindByNameLoc_thenReturnLoc() {
		Location loc = repoLoc.findLocationByNameLocation("Melati");
		serviceLoc.getByName("Melati");
	}
	
}
