package com.project.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.blog.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}
