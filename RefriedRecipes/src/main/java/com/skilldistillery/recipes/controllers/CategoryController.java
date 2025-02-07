package com.skilldistillery.recipes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.recipes.entities.Category;
import com.skilldistillery.recipes.services.CategoryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "http://localhost/"})
@RequestMapping("api/recipes")
@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping({ "categories", "categories/" })
	public List<Category> findAll() {
		return categoryService.seeAll();
	}

	@PostMapping("categories")
	public Category create(@RequestBody Category category, HttpServletResponse resp, HttpServletRequest req) {
		category = categoryService.create(category);
		try {
			if (category == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			} else {
				resp.setStatus(HttpServletResponse.SC_CREATED); // 201
				resp.setHeader("Location", req.getRequestURL().append("/").append(category.getId()).toString());
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			category = null;
			e.printStackTrace();
		}
		return category;
	}



}
