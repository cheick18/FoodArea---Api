import { Routes } from '@angular/router';
import {HomeComponent} from './pages/home/home/home.component';
import {CategoryComponent} from './features/categories/category/category.component';
import {IngredientComponent} from './features/ingredient/ingredient/ingredient.component';
import {LoginComponent} from './auth/pages/login/login/login.component';
import {RecipeComponent} from './features/recipe/recipe/recipe.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'categories', component: CategoryComponent },
  { path: 'ingredients', component: IngredientComponent },
  { path: 'recipes', component: RecipeComponent },
  { path: 'login', component: LoginComponent },
  { path: '',   redirectTo: '/', pathMatch: 'full' }
];
