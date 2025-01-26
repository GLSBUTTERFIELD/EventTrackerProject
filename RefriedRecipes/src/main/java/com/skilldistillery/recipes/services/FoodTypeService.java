package com.skilldistillery.recipes.services;

import java.util.List;

import com.skilldistillery.recipes.entities.FoodType;

public interface FoodTypeService {
	List<FoodType> showAll();
	FoodType create(FoodType foodType);
}
