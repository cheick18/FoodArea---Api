import { Component } from '@angular/core';
import {HeaderComponent} from '../../../shared/components/header/header.component';
import {ItemComponent} from '../components/item/item.component';

@Component({
  selector: 'app-category',
  imports: [HeaderComponent,ItemComponent],
  templateUrl: './category.component.html',
  styleUrl: './category.component.css'
})
export class CategoryComponent {
  title='Categories'

}
