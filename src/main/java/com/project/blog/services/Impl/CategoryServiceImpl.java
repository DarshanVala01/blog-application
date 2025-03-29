package com.project.blog.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.blog.entities.Category;
import com.project.blog.exceptions.ResourceNotFoundException;
import com.project.blog.payloads.CategoryDTO;
import com.project.blog.repositories.CategoryRepository;
import com.project.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDTO createCategoty(CategoryDTO categotyDTO) {
		Category category = this.categoryRepository.save(dtoToCategory(categotyDTO));
		return categoryToDto(category);
	}

	@Override
	public CategoryDTO updateCategoty(int categoryId, CategoryDTO categoryDTO) {
		// Fetch existing category or throw exception if not found
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category_ID", categoryId));
		
		// Update category fields from DTO
		category.setCategoryTitle(categoryDTO.getCategoryTitle());
		category.setCategoryDescription(categoryDTO.getCategoryDescription());
		
		Category updatedCategory = this.categoryRepository.save(category);
		return categoryToDto(updatedCategory);
	}

	@Override
	public void deleteCategoty(int categoryId) {
		// check if category exist
		if(!this.categoryRepository.existsById(categoryId)) {
			throw new ResourceNotFoundException("Category", "category_ID", categoryId);
		}
		this.categoryRepository.deleteById(categoryId);
	}

	@Override
	public CategoryDTO getCategoryById(int categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category_ID", categoryId));
		return categoryToDto(category);
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<Category> categories = this.categoryRepository.findAll();
		
		List<CategoryDTO> categoryDtos = categories.stream().map(category -> this.categoryToDto(category)).collect(Collectors.toList());
		return categoryDtos;
	}
	
	public Category dtoToCategory(CategoryDTO categoryDTO) {
		
		// converts type from CategoryDto into Category
		Category category = this.modelMapper.map(categoryDTO, Category.class);
		return category;
	}
	
	public CategoryDTO categoryToDto(Category category) {
		
		// converts type from Category into CategoryDto
		CategoryDTO categoryDTO = this.modelMapper.map(category, CategoryDTO.class);
		return categoryDTO;	
	}

}
