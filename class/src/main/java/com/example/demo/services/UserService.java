package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;



@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		User entity = repository.findById(id).get();
		UserDTO dto = new UserDTO(entity);
		return dto;
	}
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> users = repository.findAll();
		List<UserDTO> dtos = new ArrayList<>();
		users.forEach(user -> dtos.add(new UserDTO(user)));
		return dtos;
	}
	
	@Transactional
	public UserDTO insert(User user) {
		User entity = repository.save(user);
		UserDTO dto = new UserDTO(entity);
		return dto;
	}
}
