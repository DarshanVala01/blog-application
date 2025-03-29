package com.project.blog.services;

import java.util.List;

import com.project.blog.payloads.CategoryDTO;

public interface CategoryService {
	
	// create
	public CategoryDTO createCategoty(CategoryDTO categotyDTO);
	
	// update
	public CategoryDTO updateCategoty(int categoryId,CategoryDTO categotyDTO);
	
	// delete
	public void deleteCategoty(int categoryId);
	
	// get
	public CategoryDTO getCategoryById(int categoryId);
	
	// get All
	public List<CategoryDTO> getAllCategory(); 
}
