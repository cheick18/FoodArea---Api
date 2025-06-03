import { Component } from '@angular/core';
import {HeaderComponent} from '../../../shared/components/header/header.component';
import {RecipeCardComponent} from '../components/recipe-card/recipe-card.component';

@Component({
  selector: 'app-recipe',
  imports: [HeaderComponent,RecipeCardComponent],
  templateUrl: './recipe.component.html',
  styleUrl: './recipe.component.css'
})
export class RecipeComponent {
  title='Recipes'

}
