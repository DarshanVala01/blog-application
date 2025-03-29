package com.project.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blog.payloads.ApiResponse;
import com.project.blog.payloads.UserDTO;
import com.project.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// Create user
	@PostMapping("/create")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDto){
		UserDTO createdUser = this.userService.createUser(userDto);
		return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
	}
		
	// Update user
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDto, @PathVariable("id") Integer user_id){
		UserDTO updatedUser = this.userService.updateUser(userDto, user_id);
		return ResponseEntity.ok(updatedUser);
	}
	
	// Delete user
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("id") Integer user_id) {
		this.userService.deleteUser(user_id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
	}
	
	// Get single user
	@GetMapping("/get/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Integer user_id){
		UserDTO userDto = this.userService.getUserById(user_id);
		return ResponseEntity.ok(userDto);
	}
	
	// Get all users
	@GetMapping("/get-all")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		List<UserDTO> userDtos = this.userService.getAllUsers();
		return ResponseEntity.ok(userDtos);
	}
}
