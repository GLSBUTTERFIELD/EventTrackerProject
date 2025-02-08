import { Ingredient } from "./ingredient";
import { Recipe } from "./recipe";
import { RecipeIngredientId } from "./recipe-ingredient-id";

export class RecipeIngredient {
  id: RecipeIngredientId;
  quantityAmount: number;
  quantityUnit: string;
  notes: string;
  recipe: Recipe;
  ingredient: Ingredient;

  constructor(
    id: RecipeIngredientId = new RecipeIngredientId(),
    quantityAmount: number = 0,
    quantityUnit: string = '',
    notes: string = '',
    recipe: Recipe,
    ingredient: Ingredient,

  ){
    this.id = id;
    this.quantityAmount = quantityAmount;
    this.quantityUnit = quantityUnit;
    this.notes = notes;
    this.recipe = recipe;
    this.ingredient = ingredient;
  }

}
