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

class ReviewTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Review review;

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
		review = em.find(Review.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		review = null;
		em.close();
	}

	@Test
	void test_Review_basic_mapping() {
		assertNotNull(review);
		assertEquals("KBB", review.getTitle());
		assertEquals(2025, review.getDateCooked().getYear());
		assertEquals("start rice earlier", review.getNotesForFuture());
	}

	@Test
	void test_Review_Recipe_ManyToOne_mapping() {
		assertNotNull(review);
		assertEquals("Korean Beef Bowls", review.getRecipe().getTitle());
	}
	
}
