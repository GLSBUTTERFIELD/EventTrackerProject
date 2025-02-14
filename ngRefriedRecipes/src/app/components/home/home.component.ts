import { FoodTypeService } from './../../services/food-type.service';
import { RecipeService } from './../../services/recipe.service';
import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Recipe } from '../../models/recipe';
import { FoodType } from '../../models/food-type';

@Component({
  selector: 'app-home',
  imports: [
    CommonModule,
    FormsModule,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{
title ="Refried Recipes";
recipes: Recipe [] = [];
selected: Recipe | null = null;
editRecipe: Recipe | null = null;
newRecipe: Recipe | null = null;
foodTypes: FoodType[] = [];


constructor(
  private recipeService: RecipeService,
  private foodTypeService: FoodTypeService,
){}

ngOnInit(): void {
  this.loadRecipeList();
  this.loadFoodTypeList();
  this.countRecipes();
}

countRecipes(): number{
  console.log(this.recipes.length);
  return this.recipes.length;
}

loadRecipeList(): void {
  this.recipeService.index().subscribe({
    next:(recipeList) => {
      this.recipes = recipeList;
      this.loadFoodTypeList();
    } ,
    error: (err) => {
      console.log('HomeComponent.loadRecipeList: error');
      console.error(err);
    },
  });
}

loadFoodTypeList(): void {
  this.foodTypeService.index().subscribe({
    next:(foodTypeList) => {
      console.log(foodTypeList);
      this.foodTypes = foodTypeList;
      console.log("this.foodTypes", this.foodTypes);
    } ,
    error: (err) => {
      console.log('HomeComponent.loadFoodTypeList: error');
      console.error(err);
    },
  });
}

showRecipe(recipe: Recipe): void {
  this.selected = recipe;
}

displayList() {
  this.selected=null;
  this.newRecipe = null;
  this.editRecipe = null;
}

setEditRecipe(): void{
  this.editRecipe = Object.assign({}, this.selected);
}

addRecipe(newRecipe: Recipe){
  this.recipeService.create(newRecipe).subscribe({
    next:(newRecipe) => {
      this.selected= null;
      // this.newRecipe = new Recipe();
      this.loadRecipeList();
      this.newRecipe = null;
    } ,
    error:(err: any) =>
      console.error('Error creating Recipe in home component')
  });
  }

addRecipeForm(){
  this.selected=null;
  this.editRecipe=null;
  this.newRecipe = new Recipe();
  }

updateRecipe(recipe: Recipe, setSelected: boolean = true) : void {
  console.log(recipe);
  this.recipeService.update(recipe).subscribe({
    next: (updatedRecipe)=>{
      if (setSelected){
        this.selected = updatedRecipe;
      }
      else{
        this.editRecipe = null;
      }
      this.loadRecipeList();
      this.selected = null;
      this.editRecipe = null;
    },
    error: (err) =>
      console.log('Error updated Recipe in Home component')
  });
}

deleteRecipe(id: number){
  this.recipeService.destroy(id).subscribe({
    next:() => {
      this.loadRecipeList();
      this.selected = null;
      this.editRecipe = null;
    },
    error: (err)=>{
      console.log('Error deleting Recipe in Home component');
    }
  });

}


}
