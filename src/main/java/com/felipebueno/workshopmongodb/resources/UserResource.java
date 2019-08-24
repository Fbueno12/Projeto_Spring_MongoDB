package com.felipebueno.workshopmongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.felipebueno.workshopmongodb.domain.User;
import com.felipebueno.workshopmongodb.dto.UserDTO;
import com.felipebueno.workshopmongodb.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<User> list = service.findAll();
		List<UserDTO> listdto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listdto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User obj = service.findById(id);
		UserDTO objdto = new UserDTO(obj);
		
		return ResponseEntity.ok().body(objdto);
	}
	
}
