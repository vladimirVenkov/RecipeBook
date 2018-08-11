package venkov.vladimir.recipebook.details;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import venkov.vladimir.recipebook.R;
import venkov.vladimir.recipebook.Recipe.Recipe;

public class RecipeDetailsActivity extends Activity {
    private RecipeDetailsFragment mRecipeDetailsFragment;
    private Recipe mRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        Intent intent = getIntent();
        mRecipe = (Recipe) intent.getSerializableExtra("NAME_Recipe");
        mRecipeDetailsFragment = RecipeDetailsFragment.newInstance(mRecipe);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.details_recipe, mRecipeDetailsFragment)
                .commit();

    }
}
