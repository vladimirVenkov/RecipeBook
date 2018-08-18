package venkov.vladimir.recipebook.Recipe;

import java.io.Serializable;

public class Recipe implements Serializable{
    public String name;
    public String ingredients;
    public String cookingOperations; //public needed for firebase


    public Recipe() {
        //needed for firebase
    }


    public Recipe(String name, String ingredients, String cookingOperations) {
        setName(name);
        setIngredients(ingredients);
        setCookingOperations(cookingOperations);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getCookingOperations() {
        return cookingOperations;
    }

    public void setCookingOperations(String cookingOperations) {
        this.cookingOperations = cookingOperations;
    }
}
