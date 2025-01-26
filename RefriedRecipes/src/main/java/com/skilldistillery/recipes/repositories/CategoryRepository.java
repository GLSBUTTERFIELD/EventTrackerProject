package com.skilldistillery.recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.recipes.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
