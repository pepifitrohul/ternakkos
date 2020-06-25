package com.enigma.ternak;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import com.enigma.ternak.entities.Roles;
import com.enigma.ternak.entities.User;
import com.enigma.ternak.exception.NotFoundException;
import com.enigma.ternak.repository.UserRepo;
import com.enigma.ternak.security.service.UserDetailsServiceImpl;
import com.enigma.ternak.services.UserServices;

@RunWith(SpringRunner.class)
public class UserDetailServiceImplTest {

	public UserDetailServiceImplTest() {
	}
	
	@TestConfiguration
	static class UserDetailServiceImplTestContextConfiguration{
		@Bean
		public UserServices userServices() {
			return new UserServices();
		}
	}
	
	@Autowired
	UserDetailsServiceImpl serv;
	
	@MockBean
	UserRepo repoUser;
	
	@Before
	public void setup() throws NotFoundException{
		User user = new User("shandika", "shandika@gmail.com", "123456", (Set<Roles>) new Roles(), "cowok", "081123123345");
		List<User> userList = new ArrayList<>();
		userList.add(user);
//		Mockito.when(repoUser.findByUsername("shandika")).thenReturn(user);
	}
	
	@Test
	public void whenLoadUserByName_thenReturnUserDetailImpl() throws UsernameNotFoundException{
		Optional<User> user = repoUser.findByUsername("shandika");
		serv.loadUserByUsername("shandika");
	}
}
