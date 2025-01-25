package com.skilldistillery.recipes.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name = "quantity_amount")
	private Double quantityAmount;
	@Column(name = "quantity_unit")
	private String quantityUnit;
	private String notes;

	public Ingredient() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getQuantityAmount() {
		return quantityAmount;
	}

	public void setQuantityAmount(Double quantityAmount) {
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
		Ingredient other = (Ingredient) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", quantityAmount=" + quantityAmount + ", quantityUnit="
				+ quantityUnit + ", notes=" + notes + "]";
	}

}
