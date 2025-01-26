package com.skilldistillery.recipes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.recipes.entities.Ingredient;
import com.skilldistillery.recipes.repositories.IngredientRepository;

@Service
public class IngredientServiceImpl implements IngredientService {
	@Autowired
	IngredientRepository ingredientRepo;

	@Override
	public List<Ingredient> findAll() {
		return ingredientRepo.findAll();
	}

	@Override
	public Ingredient findById(int ingredientId) {
		return ingredientRepo.findById(ingredientId).orElse(null);
	}

	@Override
	public List<Ingredient> findByNameKeyword(String keyword) {
		keyword = "%" + keyword + "%";
		return ingredientRepo.findByNameLike(keyword);
	}

	@Override
	public Ingredient create(Ingredient ingredient) {
		Ingredient newIngredient = null;
		try {
			newIngredient = ingredient;
			ingredientRepo.saveAndFlush(newIngredient);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newIngredient;
	}

	@Override
	public Ingredient edit(Ingredient ingredient, int ingredientId) {
		Ingredient foundIngredient = null;
		try {
			foundIngredient = ingredientRepo.findById(ingredientId).orElse(null);
			foundIngredient.setDescription(ingredient.getDescription());
			foundIngredient.setImageURL(ingredient.getImageURL());
			foundIngredient.setName(ingredient.getName());
			ingredientRepo.saveAndFlush(foundIngredient);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foundIngredient;
	}

}
