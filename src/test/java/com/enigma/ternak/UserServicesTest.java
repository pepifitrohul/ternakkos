package com.enigma.ternak;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.enigma.ternak.entities.User;
import com.enigma.ternak.payload.request.UserDTO;
import com.enigma.ternak.payload.request.UserRequest;
import com.enigma.ternak.repository.RoleRepo;
import com.enigma.ternak.repository.UserRepo;
import com.enigma.ternak.services.KamarServices;
import com.enigma.ternak.services.KostServices;
import com.enigma.ternak.services.LocationServices;
import com.enigma.ternak.services.UserServices;
import com.google.common.base.Optional;

@RunWith(SpringRunner.class)
public class UserServicesTest {

	public UserServicesTest() {

	}
	
	@TestConfiguration
	static class UserServicesTestContextConfiguration{
		@Bean
		public UserServices userServices() {
			return new UserServices();
		}

	}
	
	@Autowired
	UserServices serv;
	
	@MockBean
	UserRepo repoUser;
	
	@MockBean
	KostServices servKost;
	
	@MockBean
	KamarServices servKamar;
	
	@MockBean
	PasswordEncoder encoder;
	
	@MockBean
	RoleRepo roleRepository;

	@Before
	public void setup() {
		User user = new User("test", "email@test", "123456", "Male", "081123123123");
		UserDTO userDTO = new UserDTO("test", "email@test", "Male", "081123123123");
		UserRequest req = new UserRequest("test", "email@test", "123456", "Male", "081123123123");

		List<User> list = new ArrayList<User>();
		list.add(user);
		
		Mockito.when(repoUser.save(user)).thenReturn(user);
		Mockito.when(repoUser.findAll()).thenReturn(list);
//		Mockito.when(serv.findByUsername("test")).thenReturn(userDTO);
		
	}
	
	@Test
	public void whenGetAll_returnListUser() {
		assertEquals(serv.getAll().size(), 1);
	}
	
	@Test
	public void whenUpdateUser_returnUser() {
		User user = new User("test", "email@test", "123456", "Male", "081123123123");
		serv.update(user);
		assertEquals(user.getUsername(), "test");
	}
	
	@Test
	public void whenGetById_returnUser() {
		User user = new User("test", "email@test", "123456", "Male", "081123123123");
		serv.getById(1L);
		assertEquals(user.getUsername(), "test");
	}
	
	@Test
	public void whenFindUserByUsername_returnUser() {
		UserDTO userDTO = new UserDTO("test", "email@test", "Male", "081123123123");
		serv.findByUsername(userDTO.getUsername());
		assertEquals(userDTO.getEmail(), "email@test");
	}
	
	


}
