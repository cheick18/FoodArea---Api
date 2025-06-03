import {IngredientResponse} from './ingredientResponse';
import {CommentResponse} from './commentResponse';

export interface RecipeResponse {
  id:string;
  title:string;
  instructions:string;
  imageUrl:string;
  ingredients:IngredientResponse[];
  comments:CommentResponse[];
  /*
   private Long id;
    private String title;
    private String instructions;
    private int cookingTime;
    private String imageUrl;
    private Set<IngredientResponseDto> ingredients;
    private List<CommentResponseDto> comments;
   */

}
