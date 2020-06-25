package com.enigma.ternak.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.enigma.ternak.entities.ERole;
import com.enigma.ternak.entities.Roles;
import com.enigma.ternak.entities.User;
import com.enigma.ternak.exception.NotFoundException;
import com.enigma.ternak.payload.request.UserDTO;
import com.enigma.ternak.payload.request.UserRequest;
import com.enigma.ternak.repository.RoleRepo;
import com.enigma.ternak.repository.UserRepo;

@Service
public class UserServices {

	@Autowired
	UserRepo repo;
	
	@Autowired
	KostServices servKost;
	
	@Autowired
	KamarServices servKamar;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	RoleRepo roleRepository;
	
	public User convertUser(UserDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(dto, User.class);
        return user;
    }

    public UserDTO convertUserDto(User user){
        ModelMapper modelMapper = new ModelMapper();
        UserDTO dto = modelMapper.map(user, UserDTO.class);
        return dto;
    }
    
    
    public UserDTO findByUsername (String username) {
    	Optional<User> user = repo.findByUsername(username);
    	return convertUserDto(user.get());
    }
    
    public User findUserByUsername(String username) {
    	Optional<User> user = repo.findByUsername(username);
    	return user.get();
    }
    
    
    public UserDTO createUser(UserRequest req) {
    	User user = new User(req.getUsername(), 
				 req.getEmail(),
				 encoder.encode(req.getPassword()), req.getGender() );

   
    	
		Set<String> strRoles = req.getRole();
		Set<Roles> roles = new HashSet<>();
		
		if (strRoles == null) {
		Roles userRole = roleRepository.findByName(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		} else {
		strRoles.forEach(role -> {
			switch (role) {
			case "find":
				Roles adminRole = roleRepository.findByName(ERole.ROLE_PENCARIKOS)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(adminRole);
		
				break;
			case "owner":
				Roles modRole = roleRepository.findByName(ERole.ROLE_PEMILIKKOS)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(modRole);
		
				break;
			default:
				Roles userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(userRole);
			}
		});
		}

		user.setRoles(roles);
		repo.save(user);
		return convertUserDto(user);
    }
    
    public Optional<User> getById(Long id){
		return repo.findById(id);	
    }
    
    public List<User> getAll(){
    	return repo.findAll();
    }
    
    public User update(User user) {
    	return repo.save(user);
    }

}
