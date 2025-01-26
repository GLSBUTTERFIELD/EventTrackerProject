package com.skilldistillery.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.recipes.entities.FoodType;

public interface FoodTypeRepository extends JpaRepository<FoodType,Integer> {

}
