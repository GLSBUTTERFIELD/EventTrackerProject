package com.skilldistillery.recipes.services;

import java.util.List;

import com.skilldistillery.recipes.entities.RecipeIngredient;

public interface RecipeIngredientService {
	List<RecipeIngredient> listAllByRecipeId(int recipeId);
	RecipeIngredient update(RecipeIngredient ingredient, int recipeId, int ingredientId);
	RecipeIngredient create(RecipeIngredient ingredient, int recipeId, int ingredientId);
	boolean deleteFromRecipe(int recipeId, int ingredientId);
	RecipeIngredient findRecipeIngredient(int recipeId, int ingredientId);
}
