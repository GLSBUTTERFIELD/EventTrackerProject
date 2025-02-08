import { Component } from '@angular/core';
import { ReviewComponent } from "../review/review.component";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CategoryService } from '../../services/category.service';
import { RecipeService } from '../../services/recipe.service';
import { ReviewService } from '../../services/review.service';

@Component({
  selector: 'app-recipe',
  imports: [
    ReviewComponent,
    CommonModule,
    FormsModule
],
  templateUrl: './recipe.component.html',
  styleUrl: './recipe.component.css'
})
export class RecipeComponent  {

  constructor (
    private recipeService: RecipeService,
    private reviewService: ReviewService,
    private categoryService: CategoryService,
  )
  {}


  reload(){

  }
}
