package com.skilldistillery.recipes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.recipes.entities.Ingredient;
import com.skilldistillery.recipes.entities.Recipe;
import com.skilldistillery.recipes.entities.RecipeIngredient;
import com.skilldistillery.recipes.entities.RecipeIngredientId;
import com.skilldistillery.recipes.repositories.IngredientRepository;
import com.skilldistillery.recipes.repositories.RecipeIngredientRepository;
import com.skilldistillery.recipes.repositories.RecipeRepository;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {

	@Autowired
	private RecipeIngredientRepository recipeIngredientRepo;

	@Autowired
	private RecipeRepository recipeRepo;

	@Autowired
	private IngredientRepository ingredientRepo;

	@Override
	public List<RecipeIngredient> listAllByRecipeId(int recipeId) {
		List<RecipeIngredient> ingredientsList = null;
		if (recipeRepo.existsById(recipeId)) {
			ingredientsList = recipeIngredientRepo.findByRecipeId(recipeId);
		}
		return ingredientsList;
	}
	
	@Override
	public RecipeIngredient findRecipeIngredient(int recipeId, int ingredientId) {
		RecipeIngredient recipeIngredient = null;
		recipeIngredient= recipeIngredientRepo.findByRecipeIdAndIngredientId(recipeId, ingredientId);
		return recipeIngredient;
	}
	
	@Override
	public RecipeIngredient update(RecipeIngredient ingredient, int recipeId, int ingredientId) {
		RecipeIngredient recipeIngredient = recipeIngredientRepo.findByRecipeIdAndIngredientId(recipeId, ingredientId);
		recipeIngredient.setQuantityAmount(ingredient.getQuantityAmount());
		recipeIngredient.setQuantityUnit(ingredient.getQuantityUnit());
		recipeIngredient.setNotes(ingredient.getNotes());
		recipeIngredientRepo.saveAndFlush(recipeIngredient);
		return null;
	}

	@Override
	public RecipeIngredient create(RecipeIngredient recipeIngredient, int recipeId, int ingredientId) {
		Recipe recipe = recipeRepo.findById(recipeId).orElse(null);
		Ingredient ingredient = ingredientRepo.findById(ingredientId).orElse(null);
		if (ingredient != null && recipe != null) {
			RecipeIngredientId id = new RecipeIngredientId(recipeId, ingredientId);
			recipeIngredient.setId(id);
			recipeIngredient.setRecipe(recipe);
			recipeIngredient.setIngredient(ingredient);
			return recipeIngredientRepo.saveAndFlush(recipeIngredient);
		}
		return null;
	}

	@Override
	public boolean deleteFromRecipe(int ingredientId, int recipeId) {
		boolean deleted = false;
		RecipeIngredient recipeIngredient = recipeIngredientRepo.findByRecipeIdAndIngredientId(recipeId, ingredientId);
		if (recipeIngredient != null) {
			recipeIngredientRepo.delete(recipeIngredient);
			deleted = true;
		}
		return deleted;
	}
	
}
