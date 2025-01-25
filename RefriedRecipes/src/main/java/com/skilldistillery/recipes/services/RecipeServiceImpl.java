package com.skilldistillery.recipes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.recipes.entities.Recipe;
import com.skilldistillery.recipes.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {
@Autowired
private RecipeRepository recipeRepo;
	
	@Override
	public List<Recipe> findAll() {
		return recipeRepo.findAll();
	}

	@Override
	public Recipe findById(int recipeId) {
		Optional<Recipe> recipeOpt = recipeRepo.findById(recipeId);
		Recipe foundRecipe = null;
		if(recipeOpt.isPresent()) {
			foundRecipe = recipeOpt.get();
		}
		return foundRecipe;
	}

	@Override
	public Recipe create(Recipe newRecipe) {
		Recipe created = null;
		try {
			created = recipeRepo.saveAndFlush(newRecipe);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return created;
	}

	@Override
	public Recipe update(Recipe updatedRecipe, int recipeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int recipeId) {
		// TODO Auto-generated method stub
		return false;
	}

}
