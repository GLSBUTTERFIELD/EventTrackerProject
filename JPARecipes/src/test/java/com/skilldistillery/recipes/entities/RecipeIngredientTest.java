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

class RecipeIngredientTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private RecipeIngredient recipeIngredient;

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
		recipeIngredient = em.find(RecipeIngredient.class, new RecipeIngredientId(1, 1));
	}

	@AfterEach
	void tearDown() throws Exception {
		recipeIngredient = null;
		em.close();
	}

	@Test
	void test_RecipeIngredient_basic_mapping() {
		assertNotNull(recipeIngredient);
		assertEquals("tbsp", recipeIngredient.getQuantityUnit());
	}
	
	@Test
	void test_RecipeIngredient_Recipe_ManyToOne_mapping() {
		assertNotNull(recipeIngredient);
		assertNotNull(recipeIngredient.getRecipe());
		assertEquals(15, recipeIngredient.getRecipe().getCookTime());
	}
	@Test
	void test_RecipeIngredient_Ingredient_ManyToOne_mapping() {
		assertNotNull(recipeIngredient);
		assertNotNull(recipeIngredient.getIngredient());
		assertEquals(1, recipeIngredient.getIngredient().getId());
	}
	
}
