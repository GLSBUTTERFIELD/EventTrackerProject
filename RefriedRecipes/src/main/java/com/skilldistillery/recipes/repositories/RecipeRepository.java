package com.skilldistillery.recipes.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.recipes.entities.Category;
import com.skilldistillery.recipes.entities.FoodType;
import com.skilldistillery.recipes.entities.Recipe;

public interface RecipeRepository extends JpaRepository <Recipe, Integer>{
	List<Recipe> findByEnabledTrue();
	List<Recipe> findByCategories(Category category);
	List<Recipe> findByTitleLikeOrDescriptionLike(String titleKeyword, String descriptionKeyword);
	List<Recipe> findByFoodType(FoodType foodType);
	List<Recipe> findByReviewsRatingGreaterThanEqual(double rating);
	List<Recipe> findByReviewsDifficultyLike(String keyword);
	List<Recipe> findByReviewsDateCookedBetween(LocalDate start, LocalDate end);
}
