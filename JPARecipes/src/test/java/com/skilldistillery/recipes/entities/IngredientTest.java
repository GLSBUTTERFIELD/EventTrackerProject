package com.skilldistillery.recipes.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class IngredientTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Ingredient ingredient;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPARecipes");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		ingredient = em.find(Ingredient.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		ingredient = null;
		em.close();
	}

	@Test
	void test_Ingredient_basic_mapping() {
		assertNotNull(ingredient);
		assertEquals("Oil", ingredient.getName());
	}

	@Test
	void test_Ingredient_RecipeIngredient_ManyToMany_mapping() {
		assertNotNull(ingredient);
		assertNotNull(ingredient.getRecipeIngredients());
		assertTrue(ingredient.getRecipeIngredients().size() > 0);
	}

}
