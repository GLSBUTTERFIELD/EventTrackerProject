package com.skilldistillery.recipes.services;

import java.util.List;

import com.skilldistillery.recipes.entities.Category;
import com.skilldistillery.recipes.entities.Recipe;

public interface CategoryService {

	List<Category> seeAll();
	Category create(Category category);
}
