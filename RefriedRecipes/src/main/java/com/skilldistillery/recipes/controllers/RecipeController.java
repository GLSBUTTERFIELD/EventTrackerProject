package com.skilldistillery.recipes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.recipes.entities.Recipe;
import com.skilldistillery.recipes.services.RecipeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("api")
@RestController
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

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
			e.printStackTrace();
		}
		return foundRecipe;
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
			e.printStackTrace();
		}
		return recipe;
	}

}
