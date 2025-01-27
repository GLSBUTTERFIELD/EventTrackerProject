package com.skilldistillery.recipes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.recipes.entities.Category;
import com.skilldistillery.recipes.entities.FoodType;
import com.skilldistillery.recipes.entities.Recipe;
import com.skilldistillery.recipes.repositories.CategoryRepository;
import com.skilldistillery.recipes.repositories.FoodTypeRepository;
import com.skilldistillery.recipes.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {
	@Autowired
	private RecipeRepository recipeRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private FoodTypeRepository foodTypeRepo;

	@Override
	public List<Recipe> findAll() {
		return recipeRepo.findByEnabledTrue();
	}

	@Override
	public Recipe findById(int recipeId) {
		Optional<Recipe> recipeOpt = recipeRepo.findById(recipeId);
		Recipe foundRecipe = null;
		if (recipeOpt.isPresent()) {
			foundRecipe = recipeOpt.get();
		}
		return foundRecipe;
	}

	@Override
	public List<Recipe> findByTitleOrDescriptionKeyword(String keyword) {
		keyword = "%" + keyword + "%";
		return recipeRepo.findByTitleLikeOrDescriptionLike(keyword, keyword);
	}

	@Override
	public List<Recipe> findByCategory(int categoryId) {
		if (!categoryRepo.existsById(categoryId)) {
			return null;
		} else {
			Category category = new Category();
			category.setId(categoryId);
			return recipeRepo.findByCategories(category);
		}
	}

	@Override
	public List<Recipe> findByFoodTypeId(int foodTypeId) {
		List<Recipe> recipes = null;
		if (!foodTypeRepo.existsById(foodTypeId)) {
			return null;
		} else {
			FoodType foodType = new FoodType();
			foodType.setId(foodTypeId);
			recipes = recipeRepo.findByFoodType(foodType);
		}
		return recipes;
	}

	@Override
	public Recipe create(Recipe newRecipe) {
		Recipe created = null;
		try {
			created = newRecipe;
			created.setEnabled(true);
			recipeRepo.saveAndFlush(created);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return created;
	}

	@Override
	public Recipe update(Recipe updatedRecipe, int recipeId) {
		Recipe recipeToUpdate = null;
		try {
			Optional<Recipe> recipeOpt = recipeRepo.findById(recipeId);
			if (recipeOpt.isPresent()) {
				recipeToUpdate = recipeOpt.get();
				recipeToUpdate.setCategories(updatedRecipe.getCategories());
				recipeToUpdate.setCookTime(updatedRecipe.getCookTime());
				recipeToUpdate.setDescription(updatedRecipe.getDescription());
				recipeToUpdate.setDirections(updatedRecipe.getDirections());
				recipeToUpdate.setEnabled(true);
				recipeToUpdate.setFoodType(updatedRecipe.getFoodType());
				if (recipeToUpdate.getFoodType() == null) {
					FoodType foodType = new FoodType();
					foodType.setId(1);
					recipeToUpdate.setFoodType(foodType);
				}
				recipeToUpdate.setImageURL(updatedRecipe.getImageURL());
				recipeToUpdate.setPrepTime(updatedRecipe.getPrepTime());
				recipeToUpdate.setRecipeIngredients(updatedRecipe.getRecipeIngredients());
				recipeToUpdate.setReviews(updatedRecipe.getReviews());
				recipeToUpdate.setServings(updatedRecipe.getServings());
				recipeToUpdate.setTitle(updatedRecipe.getTitle());
				recipeToUpdate.setWebsiteURL(updatedRecipe.getWebsiteURL());
				recipeRepo.saveAndFlush(recipeToUpdate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recipeToUpdate;
	}

	@Override
	public boolean delete(int recipeId) {
		boolean deleted = false;
		Optional<Recipe> recipeOpt = recipeRepo.findById(recipeId);
		if (recipeOpt.isPresent()) {
			Recipe recipe = recipeOpt.get();
			recipe.setEnabled(false);
			recipeRepo.saveAndFlush(recipe);
			deleted = true;
		}
		return deleted;
	}

}
