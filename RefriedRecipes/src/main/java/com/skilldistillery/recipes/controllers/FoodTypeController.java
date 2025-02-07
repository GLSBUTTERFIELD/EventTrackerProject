package com.skilldistillery.recipes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.recipes.entities.FoodType;
import com.skilldistillery.recipes.services.FoodTypeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "http://localhost/"})
@RequestMapping("api/recipes")
@RestController
public class FoodTypeController {

	@Autowired
	private FoodTypeService foodTypeService;

	@GetMapping({ "foodtypes", "foodtypes/" })
	public List<FoodType> showAll() {
		return foodTypeService.showAll();
	}

	@PostMapping("foodtypes")
	public FoodType addNewFoodType(@RequestBody FoodType foodType, HttpServletResponse resp, HttpServletRequest req) {
		try {
			foodType = foodTypeService.create(foodType);
			if (foodType == null) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			} else {
				resp.setStatus(HttpServletResponse.SC_CREATED); // 201
				resp.setHeader("Location", req.getRequestURL().append("/").append(foodType.getId()).toString());
			}
		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
			foodType = null;
			e.printStackTrace();
		}
		return foodType;
	}

}
