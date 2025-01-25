package com.skilldistillery.recipes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.recipes.entities.Recipe;
import com.skilldistillery.recipes.services.RecipeService;

@RequestMapping("api")
@RestController
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@GetMapping(path= {"recipes/", "recipes"})
	public List<Recipe> findAll() {
		return recipeService.findAll();
	}
}
