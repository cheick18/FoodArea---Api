import { Component } from '@angular/core';
import {RecipeCardComponent} from '../../../../features/recipe/components/recipe-card/recipe-card.component';

@Component({
  selector: 'app-latest-recipes',
  imports: [RecipeCardComponent],
  templateUrl: './latest-recipes.component.html',
  styleUrl: './latest-recipes.component.css'
})
export class LatestRecipesComponent {

}
