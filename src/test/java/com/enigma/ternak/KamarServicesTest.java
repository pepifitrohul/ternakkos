package com.enigma.ternak;



import static org.junit.Assert.assertEquals;

import java.sql.Date;
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
import org.springframework.test.context.junit4.SpringRunner;

import com.enigma.ternak.entities.Kamar;
import com.enigma.ternak.payload.request.KamarDTO;
import com.enigma.ternak.payload.request.KamarRequest;
import com.enigma.ternak.repository.KamarRepo;
import com.enigma.ternak.repository.KostRepo;
import com.enigma.ternak.repository.UserRepo;
import com.enigma.ternak.services.KamarServices;

import javassist.NotFoundException;

@RunWith(SpringRunner.class)
public class KamarServicesTest {

	public KamarServicesTest() {

	}
	
	@TestConfiguration
	static class KamarServicesTestTestContextConfiguration{
		@Bean
		public KamarServices kamarServices() {
			return new KamarServices();
		}
	}
	
	@Autowired
	KamarServices serv;
	
	@MockBean
	KamarRepo repoKamar;
	
	@MockBean
	KostRepo repoKost;
	
	@MockBean
	UserRepo repoUser;
	
	@Before
	public void setup() {
		Kamar kamar = new Kamar((long)1, "test", Date.valueOf("2000-01-01"), 1);
		KamarDTO kamarDTO = new KamarDTO(1L, Date.valueOf("2000-01-01"), "test", 1);
		KamarRequest kamarReq = new KamarRequest("test");
		List<Kamar> kamarList = new ArrayList<Kamar>();
		kamarList.add(kamar);
		
		Mockito.when(repoKamar.findKamarByName("test")).thenReturn(kamar);
		Mockito.when(repoKamar.save(kamarReq)).thenReturn(kamarReq);
	}
	
	@Test
	public void whenCreateKamar_thenReturnKamar() {
		Kamar kamar = new Kamar((long)1, "test", Date.valueOf("2000-01-01"), 1);
		serv.saveKamar(kamar);
	}
	
	@Test
	public void whenFindAllKamar() {
		assertEquals(serv.getAll().size(), 0);
	}
	
	@Test
	public void whenFindAllKamarDto() {
		assertEquals(serv.findAllKamar().size(), 0);
	}
	
	@Test
	public void whenGetKamarByName_thenReturnKamarDTO() {
		assertEquals(serv.getByName("test").getName(), "test");
	}
	
	@Test
	public void whenDeleteKamarById() {
		Optional<Kamar> kam = repoKamar.findById((long)1);
		serv.deleteById(1L);
	}
	
	@Test
	public void whenDeleteKamarByName() {
		serv.deleteByName("test");;
	}
	
	@Test
	public void whenFindById() {
		serv.findById(1L);
	}
	
	@Test
	public void whenFindKamarById_thenReturnKamarDTO() throws NotFoundException {
		Optional<Kamar> kamr = repoKamar.findById((long)1);
		ModelMapper modelMapper= new ModelMapper();
		KamarDTO dto= modelMapper.map(kamr, KamarDTO.class);
		assertEquals(serv.findById(1L), 1L);
	}
	
	@Test
	public void whenCreateKamar() {
		Optional<Kamar> kost = repoKamar.findById(1L);
		KamarRequest request = new KamarRequest("test");
		Kamar kmr = new Kamar();
		kmr.setName(request.getName());;
		kmr.setStatus(0);
		repoKamar.save(kmr);
		
	}
}
