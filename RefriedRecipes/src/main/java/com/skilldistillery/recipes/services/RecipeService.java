package com.skilldistillery.recipes.services;

import java.time.LocalDate;
import java.util.List;

import com.skilldistillery.recipes.entities.Recipe;

public interface RecipeService {
	List<Recipe> findAll();
	Recipe findById(int recipeId);
	Recipe create(Recipe newRecipe);
	Recipe update(Recipe updatedRecipe, int recipeId);
	boolean delete(int recipeId);
	List<Recipe> findByCategory(int categoryId);
	List<Recipe> findByTitleOrDescriptionKeyword(String keyword);
	List<Recipe> findByFoodTypeId(int foodTypeId);
	List<Recipe> findByReviewRatingGreaterThanOrEqualTo(double rating);
	List<Recipe> findByReviewDifficultyLevel(String keyword);
	List<Recipe> findByReviewDatesCooked(LocalDate start, LocalDate end);
}
