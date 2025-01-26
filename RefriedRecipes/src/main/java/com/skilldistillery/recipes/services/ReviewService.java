package com.skilldistillery.recipes.services;

import java.util.List;

import com.skilldistillery.recipes.entities.Review;

public interface ReviewService {
	List<Review> showAll();
	List<Review> findByRecipeId(int recipeId);
	Review showOne(int reviewId);
	Review create (Review review);
	Review update(Review review, int reviewId);
	
}
