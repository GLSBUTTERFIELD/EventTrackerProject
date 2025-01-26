package com.skilldistillery.recipes.services;

import java.util.List;

import com.skilldistillery.recipes.entities.Ingredient;

public interface IngredientService {
	List<Ingredient> findAll();
	Ingredient findById(int ingredientId);
	List<Ingredient> findByNameKeyword(String keyword);
	Ingredient create(Ingredient ingredient);
	Ingredient edit(Ingredient ingredient, int ingredientId);

}
