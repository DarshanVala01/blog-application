package com.project.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
	
	private int id;
	
	@NotBlank(message = "Please enter valid name.")
	private String name;
	
	@Email(message = "Please enter valid email id.")
	@NotBlank
	private String email;
	
	@NotBlank
	@Size(min = 5, max = 8,message = "Password must be between 5 to 8 character")
	@Pattern(regexp = "")
	private String password;
	
	@NotBlank(message = "Please enter valid string about.")
	private String about;
	
}
