package com.skilldistillery.recipes.services;

import java.util.List;

import com.skilldistillery.recipes.entities.Recipe;

public interface RecipeService {
	List<Recipe> findAll();
	Recipe findById(int recipeId);
	Recipe create(Recipe newRecipe);
	Recipe update(Recipe updatedRecipe, int recipeId);
	boolean delete(int recipeId);
	
}
