package com.skilldistillery.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.recipes.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

}
