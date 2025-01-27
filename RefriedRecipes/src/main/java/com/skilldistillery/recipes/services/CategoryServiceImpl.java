package com.skilldistillery.recipes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.recipes.entities.Category;
import com.skilldistillery.recipes.repositories.CategoryRepository;
import com.skilldistillery.recipes.repositories.RecipeRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public List<Category> seeAll() {
		return categoryRepo.findAll();
	}

	@Override
	public Category create(Category category) {
		Category newCategory = null;
		try {
			newCategory = category;
			categoryRepo.saveAndFlush(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newCategory;
	}
}
