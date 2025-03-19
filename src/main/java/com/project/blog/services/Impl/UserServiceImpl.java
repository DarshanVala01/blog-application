package com.project.blog.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.blog.entities.User;
import com.project.blog.exceptions.ResourceNotFoundException;
import com.project.blog.payloads.UserDTO;
import com.project.blog.repositories.UserRepository;
import com.project.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO createUser(UserDTO userDto) {
		User savedUser = this.userRepository.save(dtoToUser(userDto));
		return userToDto(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO userDto, Integer id) {
		// Fetch existing user or throw exception if not found
		User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","User_ID",id));
		
		// Update user fields from DTO
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		// Save updated user
		User updatedUser = this.userRepository.save(user);

		return userToDto(updatedUser);
	}

	@Override
	public UserDTO getUserById(Integer id) {
		User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","User_ID",id));
		return userToDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = this.userRepository.findAll();
		
//		List<UserDTO> userDtos = new ArrayList<>();
//		for(User user : users) {
//			userDtos.add(userToDto(user));
//		}
		
//		-------------------  OR ---------------------------
		
		List<UserDTO> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer id) {
		// check if user exists
		if(!this.userRepository.existsById(id)) {
			throw new ResourceNotFoundException("User", "User_ID", id);
		}
		
		// delete the user
		this.userRepository.deleteById(id);
	}
	
	public User dtoToUser(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setAbout(userDTO.getAbout());
		return user;
	}
	
	public UserDTO userToDto(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		userDTO.setAbout(user.getAbout());
		return userDTO;
	}

}
