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

class CategoryTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Category category;

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
		category = em.find(Category.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		category = null;
		em.close();
	}

	@Test
	void test_Category_basic_mapping() {
		assertNotNull(category);
		assertEquals("Breakfast", category.getName());
	}
	
	@Test
	void test_Category_Recipe_ManyToMany_mapping() {
		category = em.find(Category.class, 3);
		assertNotNull(category);
		assertNotNull(category.getRecipes());
		assertTrue(category.getRecipes().size() > 0);
	}

}
