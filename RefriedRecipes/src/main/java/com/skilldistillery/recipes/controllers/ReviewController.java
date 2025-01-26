package com.skilldistillery.recipes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.recipes.entities.Review;
import com.skilldistillery.recipes.services.ReviewService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("api/recipes")
@RestController
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping({ "reviews", "reviews/" })
	public List<Review> showAll() {
		return reviewService.showAll();
	}

	@GetMapping("{recipeId}/reviews/{reviewId}")
	public Review showReview(@PathVariable("recipeId") int recipeId, @PathVariable("reviewId") int reviewId,
			HttpServletResponse resp) {
		Review review = null;
		try {
			review = reviewService.showOne(reviewId);
			if (review == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			review = null;
			e.printStackTrace();
		}
		return review;
	}

	@PostMapping("{recipeId}/reviews")
	public Review addNewReview(@PathVariable("recipeId") int recipeId, @RequestBody Review review,
			HttpServletResponse resp, HttpServletRequest req) {
		try {
			review = reviewService.create(review);
			if (review == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			} else {
				resp.setStatus(HttpServletResponse.SC_CREATED); // 201
				resp.setHeader("Location",
						req.getRequestURL().append("/" + recipeId + "/").append(review.getId()).toString());
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			review = null;
			e.printStackTrace();
		}
		return review;
	}

	@PutMapping("{recipeId}/reviews/{reviewId}")
	public Review edit(@PathVariable("reviewId") int reviewId, @PathVariable("recipeId") int recipeId,
			@RequestBody Review review, HttpServletResponse resp) {
		try {
			review = reviewService.update(review, reviewId);
			if (review == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			review = null;
			e.printStackTrace();
		}
		return review;
	}

	@DeleteMapping("{recipeId}/reviews/{reviewId}")
	public void disable(@PathVariable("recipeId") int recipeId, @PathVariable("reviewId") int reviewId,
			HttpServletResponse resp) {
			try {
				if (reviewService.disable(reviewId)) {
					resp.setStatus(HttpServletResponse.SC_NO_CONTENT); //204
				}
				else {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND); //404
				}
			} catch (Exception e) {
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); //400
				e.printStackTrace();
			}
			
		
	}

}
