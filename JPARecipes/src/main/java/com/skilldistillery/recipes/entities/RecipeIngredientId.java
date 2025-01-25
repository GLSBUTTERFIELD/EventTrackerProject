package com.skilldistillery.recipes.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
@Embeddable
public class RecipeIngredientId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "recipe_id")
	private int recipeId;
	@Column(name = "ingredient_id")
	private int ingredientId;
	public RecipeIngredientId() {
		super();
	}
	public RecipeIngredientId(int recipeId, int ingredientId) {
		super();
		this.recipeId = recipeId;
		this.ingredientId = ingredientId;
	}
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public int getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ingredientId, recipeId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeIngredientId other = (RecipeIngredientId) obj;
		return ingredientId == other.ingredientId && recipeId == other.recipeId;
	}
	@Override
	public String toString() {
		return "RecipeIngredientId [recipeId=" + recipeId + ", ingredientId=" + ingredientId + "]";
	}
	
}
