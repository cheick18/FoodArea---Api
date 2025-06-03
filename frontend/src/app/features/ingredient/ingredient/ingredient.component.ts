import { Component } from '@angular/core';
import {HeaderComponent} from '../../../shared/components/header/header.component';

@Component({
  selector: 'app-ingredient',
  imports: [HeaderComponent],
  templateUrl: './ingredient.component.html',
  styleUrl: './ingredient.component.css'
})
export class IngredientComponent {
  title='Ingredients'

}
