package com.project.blog.services;

import java.util.List;

import com.project.blog.payloads.UserDTO;

public interface UserService {
	
	public UserDTO createUser(UserDTO user);
	
	public UserDTO updateUser(UserDTO user, Integer id);
	
	public UserDTO getUserById(Integer id);
	
	public List<UserDTO> getAllUsers();
	
	public void deleteUser(Integer id);
	
}
