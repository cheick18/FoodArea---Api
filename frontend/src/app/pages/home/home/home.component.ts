import { Component } from '@angular/core';
import {HeroBannerComponent} from '../components/hero-banner/hero-banner.component';
import {LatestRecipesComponent} from '../components/latest-recipes/latest-recipes.component';
import {SpaceSectionComponent} from '../../../shared/components/space-section/space-section.component';
import {CategoriesTabComponent} from '../components/categories-tab/categories-tab.component';

@Component({
  selector: 'app-home',
  imports: [HeroBannerComponent,LatestRecipesComponent,SpaceSectionComponent,CategoriesTabComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
