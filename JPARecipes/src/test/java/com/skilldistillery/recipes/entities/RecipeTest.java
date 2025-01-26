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

class RecipeTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Recipe recipe;

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
		recipe = em.find(Recipe.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		recipe = null;
		em.close();
	}

	@Test
	void test_Recipe_basic_mapping() {
		assertNotNull(recipe);
		assertEquals("Korean Beef Bowls", recipe.getTitle());
		assertEquals(15, recipe.getPrepTime());
	}
	
	@Test
	void test_Recipe_FoodType_ManyToOne_mapping() {
		assertNotNull(recipe);
		assertEquals("Korean", recipe.getFoodType().getName());
	}
	
	@Test
	void test_Recipe_Review_OneToMany_mapping() {
		assertNotNull(recipe);
		assertNotNull(recipe.getReviews());
		assertTrue(recipe.getReviews().size() > 0);
	}
	
	@Test
	void test_Recipe_Category_ManyToMany_mapping() {
		assertNotNull(recipe);
		assertNotNull(recipe.getCategories());
		assertTrue(recipe.getCategories().size() > 0 );
	}

	@Test
	void test_Recipe_RecipeIngredient_OneToMany_mapping() {
		assertNotNull(recipe);
		assertNotNull(recipe.getRecipeIngredients());
		assertTrue(recipe.getRecipeIngredients().size() > 0 );
	}

}
