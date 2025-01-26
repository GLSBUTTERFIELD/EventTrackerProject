package com.skilldistillery.recipes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.recipes.entities.Review;
import com.skilldistillery.recipes.repositories.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepo;

	@Override
	public List<Review> showAll() {
		return reviewRepo.findAll();
	}
	
	@Override
	public Review showOne(int reviewId) {
		return reviewRepo.findById(reviewId).orElse(null);
	}

	@Override
	public List<Review> findByRecipeId(int recipeId) {
		return reviewRepo.findByRecipeId(recipeId);
	}

	@Override
	public Review create(Review review) {
		return reviewRepo.saveAndFlush(review);
	}

	@Override
	public Review update(Review review, int reviewId) {
		Review updatedReview = null;
		updatedReview = reviewRepo.findById(reviewId).orElse(null);
		if (updatedReview != null) {
			if (updatedReview.getRecipe() == null) {
				updatedReview = null;
			} else {
				updatedReview.setTitle(review.getTitle());
				updatedReview.setDateCooked(review.getDateCooked());
				updatedReview.setDifficulty(review.getDifficulty());
				updatedReview.setEnabled(review.getEnabled());
				updatedReview.setNotesForFuture(review.getNotesForFuture());
				updatedReview.setRating(review.getRating());
				updatedReview.setRemarks(review.getRemarks());
				updatedReview.setRecipe(review.getRecipe());
				reviewRepo.saveAndFlush(updatedReview);
			}
		}
		return updatedReview;
	}



}
