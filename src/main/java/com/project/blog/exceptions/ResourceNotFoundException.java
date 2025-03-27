package com.project.blog.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException{
	
	String resourceName;
	String fieldName;
	long fieldId;
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldId) {
		super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldId));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldId = fieldId;
	}
	
	
	
}
