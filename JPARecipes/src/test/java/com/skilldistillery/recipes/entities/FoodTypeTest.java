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

class FoodTypeTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private FoodType foodType;

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
		foodType = em.find(FoodType.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		foodType = null;
		em.close();
	}

	@Test
	void test_FoodType_basic_mapping() {
		assertNotNull(foodType);
		assertEquals("Other", foodType.getName());
	}
	
	@Test 
	void test_FoodType_Recipe_OneToMany_mapping() {
		foodType = em.find(FoodType.class, 2);
		assertNotNull(foodType);
		assertNotNull(foodType.getRecipes());
		assertTrue(foodType.getRecipes().size() > 0);
	}

}
