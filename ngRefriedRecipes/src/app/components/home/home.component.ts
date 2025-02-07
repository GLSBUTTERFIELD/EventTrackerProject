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

}
