import { FoodType } from "./food-type";

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
}

}
