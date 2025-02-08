export class RecipeIngredientId {
  recipeId: number;
  ingredientId: number;

constructor(
  recipeId: number = 0,
  ingredientId: number = 0,
){
  this.ingredientId = ingredientId;
  this.recipeId = recipeId;
}
}
