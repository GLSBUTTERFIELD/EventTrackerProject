package com.skilldistillery.recipes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.recipes.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	List<Review> findByRecipeId(int recipeId);
}
