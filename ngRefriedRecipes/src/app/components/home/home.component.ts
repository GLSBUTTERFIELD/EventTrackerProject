import { RecipeService } from './../../services/recipe.service';
import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Recipe } from '../../models/recipe';

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
recipes: Recipe [] = [];
selected: Recipe | null = null;
editRecipe: Recipe | null = null;
newRecipe: Recipe = new Recipe();

constructor(
  private recipeService: RecipeService,
){}

ngOnInit(): void {
  this.loadRecipeList();
}

loadRecipeList(): void {
  this.recipeService.index().subscribe({
    next:(recipeList) => {
      this.recipes = recipeList;
    } ,
    error: (err) => {
      console.log('HomeComponent.loadRecipes: error');
      console.error(err);
    },
  });
}

showRecipe(recipe: Recipe): void {
  this.selected = recipe;
}

displayList() {
  this.selected=null;
}

setEditRecipe(): void{
  this.editRecipe = Object.assign({}, this.selected);
}

updateRecipe(recipe: Recipe, setSelected: boolean = true) : void {
  this.recipeService.update(recipe).subscribe({
    next: (updatedRecipe)=>{
      this.loadRecipeList();
      if (setSelected){
        this.selected = updatedRecipe;
      }
      this.editRecipe = null;
    },
    error: (err) =>
      console.log('Error updated Recipe in Home component')
  });
}


}
