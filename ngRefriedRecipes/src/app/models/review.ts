import { last } from "rxjs";
import { Recipe } from "./recipe";

export class Review {
  id: number;
  title: string;
  dateCooked: string;
  remarks: string;
  difficulty: string;
  rating: number;
  notesForFuture: string;
  lastUpdate: string;
  enabled: boolean;
  recipe: Recipe;

  constructor (
    id: number = 0,
    title: string = '',
    dateCooked: string = '',
    remarks: string = '',
    difficulty: string = '',
    rating: number = 0,
    notesForFuture: string = '',
    lastUpdate: string = '',
    enabled: boolean = true,
    recipe: Recipe = new Recipe (),
  ){
    this.id = id;
    this.title = title;
    this.dateCooked = dateCooked;
    this.remarks = remarks;
    this.difficulty =  difficulty;
    this.rating = rating;
    this.notesForFuture = notesForFuture;
    this.lastUpdate = lastUpdate;
    this.enabled = enabled;
    this.recipe = recipe;
  }

}
