package com.skilldistillery.recipes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.recipes.entities.RecipeIngredient;
import com.skilldistillery.recipes.services.RecipeIngredientService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "http://localhost/"})
@RequestMapping("api")
@RestController
public class RecipeIngredientController {

	@Autowired
	private RecipeIngredientService recipeIngredientService;

	@GetMapping("recipes/{recipeId}/ingredients")
	public List<RecipeIngredient> findIngredientsByRecipeId(@PathVariable("recipeId") int recipeId,
			HttpServletResponse resp) {
		List<RecipeIngredient> ingredients = null;
		try {
			ingredients = recipeIngredientService.listAllByRecipeId(recipeId);
			if (ingredients == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			} else {
				resp.setStatus(HttpServletResponse.SC_OK); // 200
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			e.printStackTrace();
			ingredients = null;
		}
		return ingredients;
	}

	@PostMapping("recipes/{recipeId}/ingredients/{ingredientId}")
	public RecipeIngredient addRecipeIngredient(@PathVariable("recipeId") int recipeId,
			@PathVariable("ingredientId") int ingredientId, @RequestBody RecipeIngredient recipeIngredient,
			HttpServletResponse resp, HttpServletRequest req) {
		try {
			recipeIngredient = recipeIngredientService.create(recipeIngredient, ingredientId, recipeId);
			if (recipeIngredient == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			} else {
				resp.setStatus(HttpServletResponse.SC_CREATED); // 201
				resp.setHeader("Location", req.getRequestURL().append("/recipes/").append(recipeId)
						.append("/ingredients/").append(ingredientId).toString());
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			recipeIngredient = null;
			e.printStackTrace();
		}
		return recipeIngredient;
	}

//this is working but giving 404 when the code inside if statement is uncommented	
	@PutMapping("recipes/{recipeId}/ingredients/{ingredientId}")
	public RecipeIngredient edit(@PathVariable("recipeId") int recipeId, @PathVariable("ingredientId") int ingredientId,
			@RequestBody RecipeIngredient recipeIngredient, HttpServletResponse resp) {
		try {
			recipeIngredient = recipeIngredientService.update(recipeIngredient, recipeId, ingredientId);
			if (recipeIngredient == null) {
//				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			recipeIngredient = null;
			e.printStackTrace();
		}
		return recipeIngredient;
	}

	@DeleteMapping("recipes/{recipeId}/ingredients/{ingredientId}")
	public void removeRecipeIngredient(@PathVariable("recipeId") int recipeId,
			@PathVariable("ingredientId") int ingredientId, HttpServletResponse resp) {
		try {
			boolean deleted = recipeIngredientService.deleteFromRecipe(ingredientId, recipeId);
			if (deleted) {
				resp.setStatus(HttpServletResponse.SC_NO_CONTENT); // 304
			} else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			e.printStackTrace();
		}

	}

}
