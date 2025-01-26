package com.skilldistillery.recipes.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="recipe_ingredient")
public class RecipeIngredient {

	@EmbeddedId
	private RecipeIngredientId id;
	@Column(name = "quantity_amount")
	private String quantityAmount;
	@Column(name = "quantity_unit")
	private String quantityUnit;
	private String notes;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="recipe_id")
	@MapsId(value = "recipeId")
	private Recipe recipe;
	@JsonIgnoreProperties({"recipeIngredients"})
	@ManyToOne
	@JoinColumn(name="ingredient_id")
	@MapsId(value="ingredientId")
	private Ingredient ingredient;

	public RecipeIngredient() {
	}

	public RecipeIngredientId getId() {
		return id;
	}

	public void setId(RecipeIngredientId id) {
		this.id = id;
	}

	public String getQuantityAmount() {
		return quantityAmount;
	}

	public void setQuantityAmount(String quantityAmount) {
		this.quantityAmount = quantityAmount;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeIngredient other = (RecipeIngredient) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "RecipeIngredient [id=" + id + ", quantityAmount=" + quantityAmount + ", quantityUnit=" + quantityUnit
				+ ", notes=" + notes + "]";
	}

}
