package com.skilldistillery.recipes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.recipes.entities.RecipeIngredient;
import com.skilldistillery.recipes.entities.RecipeIngredientId;

public interface RecipeIngredientRepository extends JpaRepository <RecipeIngredient, RecipeIngredientId> {
	List<RecipeIngredient> findByRecipeId(int recipeId);
//	RecipeIngredient update(RecipeIngredient recipeIngredient, int recipeId, int ingredientId);
//	RecipeIngredient create(RecipeIngredient recipeIngredient, int recipeId, int ingredientId);
	RecipeIngredient findByRecipeIdAndIngredientId(int recipeId, int ingredientId);
}
