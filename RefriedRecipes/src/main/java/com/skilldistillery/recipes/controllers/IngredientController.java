package com.skilldistillery.recipes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.recipes.entities.Ingredient;
import com.skilldistillery.recipes.services.IngredientService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("api")
@RestController
public class IngredientController {

	@Autowired
	private IngredientService ingredientService;

	@GetMapping({ "ingredients", "ingredients/" })
	public List<Ingredient> findAll() {
		return ingredientService.findAll();
	}

	@GetMapping("ingredients/{ingredientId}")
	public Ingredient findById(@PathVariable("ingredientId") int ingredientId, HttpServletResponse resp) {
		Ingredient foundIngredient = ingredientService.findById(ingredientId);
		try {
			if (foundIngredient == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			} else {
				resp.setStatus(HttpServletResponse.SC_OK); // 200
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			foundIngredient = null;
			e.printStackTrace();
		}
		return foundIngredient;
	}

	@GetMapping("ingredients/search/{keyword}")
	public List<Ingredient> findByKeyword(@PathVariable("keyword") String keyword, HttpServletResponse resp) {
		List<Ingredient> foundIngredients = ingredientService.findByNameKeyword(keyword);
		try {
			if (foundIngredients == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			foundIngredients = null;
			e.printStackTrace();
		}
		return foundIngredients;
	}

	@PostMapping("ingredients")
	public Ingredient addNewIngredient(@RequestBody Ingredient ingredient, HttpServletResponse resp,
			HttpServletRequest req) {
		try {
			ingredient = ingredientService.create(ingredient);
			if (ingredient == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			} else {
				resp.setStatus(HttpServletResponse.SC_CREATED); // 201
				resp.setHeader("Location", req.getRequestURL().append("/").append(ingredient.getId()).toString());
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			ingredient = null;
			e.printStackTrace();
		}
		return ingredient;
	}

	@PutMapping("ingredients/{ingredientId}")
	public Ingredient editIngredient(@PathVariable("ingredientId") int ingredientId, @RequestBody Ingredient ingredient,
			HttpServletResponse resp) {
		ingredient = ingredientService.edit(ingredient, ingredientId);
		try {
			if (ingredient == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			ingredient = null;
			e.printStackTrace();
		}
		return ingredient;
	}

}
