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

import com.skilldistillery.recipes.entities.Recipe;
import com.skilldistillery.recipes.entities.Review;
import com.skilldistillery.recipes.services.RecipeService;
import com.skilldistillery.recipes.services.ReviewService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("api")
@RestController
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@Autowired
	private ReviewService reviewService;

	@GetMapping(path = { "recipes/", "recipes" })
	public List<Recipe> findAll() {
		return recipeService.findAll();
	}

	@GetMapping("recipes/{recipeId}")
	public Recipe findById(@PathVariable("recipeId") int recipeId, HttpServletResponse resp) {
		Recipe foundRecipe = null;
		try {
			foundRecipe = recipeService.findById(recipeId);
			if (foundRecipe == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			foundRecipe = null;
			e.printStackTrace();
		}
		return foundRecipe;
	}

	@GetMapping("recipes/search/{keyword}")
	public List<Recipe> searchByKeyword(@PathVariable("keyword") String keyword, HttpServletResponse resp) {
		List<Recipe> recipes = null;
		try {
			recipes = recipeService.findByTitleOrDescriptionKeyword(keyword);
			if (recipes == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			recipes = null;
			e.printStackTrace();
		}
		return recipes;
	}

	@GetMapping("recipes/search/categories/{categoryId}")
	public List<Recipe> findByCategoryId(@PathVariable("categoryId") int categoryId, HttpServletResponse resp) {
		List<Recipe> recipes = null;
		try {
			recipes = recipeService.findByCategory(categoryId);
			if (recipes == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404

			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			e.printStackTrace();
			recipes = null;
		}
		return recipes;
	}

	@GetMapping("recipes/search/foodtypes/{foodTypeId}")
	public List<Recipe> findByFoodTypeId(@PathVariable("foodTypeId") int foodTypeId, HttpServletResponse resp) {
		List<Recipe> recipes = null;
		try {
			recipes = recipeService.findByFoodTypeId(foodTypeId);
			if (recipes == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); //404
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			recipes = null;
			e.printStackTrace();
		}
		return recipes;
	}

	@GetMapping("recipes/{recipeId}/reviews")
	public List<Review> showReviewsByRecipe(@PathVariable("recipeId") int recipeId, HttpServletResponse resp) {
		Recipe recipe = recipeService.findById(recipeId);
		List<Review> reviews = null;
		if (recipe != null) {
			try {
				reviews = reviewService.findByRecipeId(recipeId);

			} catch (Exception e) {
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
				reviews = null;
				e.printStackTrace();
			}
		} else {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			reviews = null;
		}
		return reviews;
	}

	@PostMapping("recipes")
	public Recipe addNewRecipe(@RequestBody Recipe recipe, HttpServletResponse resp, HttpServletRequest req) {
		try {
			recipeService.create(recipe);
			if (recipe == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			} else {
				resp.setStatus(HttpServletResponse.SC_CREATED); // 201
				resp.setHeader("Location", req.getRequestURL().append("/").append(recipe.getId()).toString());
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);// 400
			recipe = null;
			e.printStackTrace();
		}
		return recipe;
	}

	@PutMapping("recipes/{recipeId}")
	public Recipe updateRecipe(@PathVariable("recipeId") int recipeId, @RequestBody Recipe recipe,
			HttpServletResponse resp) {
		try {
			recipeService.update(recipe, recipeId);
			if (recipe == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			} else {
				resp.setStatus(HttpServletResponse.SC_OK); // 200
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			recipe = null;
			e.printStackTrace();
		}
		return recipe;
	}

	@DeleteMapping("recipes/{recipeId}")
	public void deleteRecipe(@PathVariable("recipeId") int recipeId, HttpServletResponse resp) {
		try {
			if (recipeService.delete(recipeId)) {
				resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
			} else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			e.printStackTrace();
		}
	}
}
