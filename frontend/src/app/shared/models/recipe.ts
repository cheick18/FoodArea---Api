import {Ingredient} from './ingredient';

interface Recipe {
  title: string;
  instructions: string;
  cookingTime: number;
  imageUrl?: string;
  ingredients: Ingredient[];
  userId: number;
  categoryId: number;
  tagIds?: Set<number>;
}
