package com.skilldistillery.recipes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.recipes.entities.FoodType;
import com.skilldistillery.recipes.repositories.FoodTypeRepository;

@Service
public class FoodTypeServiceImpl implements FoodTypeService {

	@Autowired
	private FoodTypeRepository foodTypeRepo;

	@Override
	public List<FoodType> showAll() {
		return foodTypeRepo.findAll();
	}

	@Override
	public FoodType create(FoodType foodType) {
		FoodType created = null;
		try {
			created = foodType;
			foodTypeRepo.saveAndFlush(created);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return created;
	}

}
