package com.project.blog.payloads;

import lombok.Data;

@Data
public class UserDTO {
	
	private int id;
	private String name;
	private String email;
	private String password;
	private String about;
	
}
