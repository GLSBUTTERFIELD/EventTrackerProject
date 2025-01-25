package com.skilldistillery.recipes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.recipes.entities.Recipe;

public interface RecipeRepository extends JpaRepository <Recipe, Integer>{
	List<Recipe> findByEnabledTrue();

}
