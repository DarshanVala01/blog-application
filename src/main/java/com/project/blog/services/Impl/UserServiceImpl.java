package com.project.blog.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.blog.entities.User;
import com.project.blog.payloads.UserDTO;
import com.project.blog.repositories.UserRepository;
import com.project.blog.services.UserService;

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO createUser(UserDTO user) {
		User savedUser = this.userRepository.save(convertIntoUser(user));
		return convertIntoUserDTO(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO user, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	private User convertIntoUser(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setAbout(userDTO.getAbout());
		return user;
	}
	
	private UserDTO convertIntoUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		userDTO.setAbout(user.getAbout());
		return userDTO;
	}

}
