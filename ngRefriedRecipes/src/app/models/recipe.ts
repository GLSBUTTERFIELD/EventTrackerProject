import { Category } from "./category";
import { FoodType } from "./food-type";
import { RecipeIngredient } from "./recipe-ingredient";
import { Review } from "./review";

export class Recipe {
  id: number;
  title: string;
  description: string;
  servings: string;
  prepTime: number;
  cookTime: number;
  totalTime: number;
  directions: string;
  source: string;
  websiteUrl: string;
  imageUrl: string;
  enabled: boolean;
  createDate: string;
  lastUpdate: string;
  foodType: FoodType;
  reviews: Review [] | undefined;
  categories: Category [] | undefined;
  recipeIngredients: RecipeIngredient[] | undefined;

constructor(
  id: number = 0,
  title: string = '',
  description: string = '',
  servings: string = ' ',
  prepTime: number = 0,
  cookTime: number = 0,
  totalTime: number = 0,
  directions: string = '',
  source: string = ' ',
  websiteUrl: string = '',
  imageUrl: string = ' ',
  enabled: boolean = true,
  createDate: string = '',
  lastUpdate: string = '',
  foodType: FoodType = new FoodType(),
  reviews: Review[] = [],
  categories: Category[] = [],
  recipeIngredients: RecipeIngredient[] = [],
)
{
this.id = id;
this.title = title;
this.description = description;
this.servings = servings;
this.prepTime = prepTime;
this.cookTime = cookTime;
this.totalTime = totalTime;
this.directions = directions;
this.source = source;
this.websiteUrl = websiteUrl;
this.imageUrl =  imageUrl;
this.createDate = createDate;
this.lastUpdate = lastUpdate;
this.enabled = enabled;
this.foodType = foodType;
this.reviews = reviews;
this.categories = categories;
this.recipeIngredients = recipeIngredients;
}

}
