package venkov.vladimir.recipebook.details;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import venkov.vladimir.recipebook.R;
import venkov.vladimir.recipebook.Recipe.Recipe;
import venkov.vladimir.recipebook.views.BaseDrawerActivity;

public class RecipeDetailsActivity extends BaseDrawerActivity {
    public static final long IDENTIFIER = 2;
    private RecipeDetailsFragment mRecipeDetailsFragment;
    private Recipe mRecipe;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        mToolbar = findViewById(R.id.drawer_toolbar);
        setSupportActionBar(mToolbar);

        Intent intent = getIntent();
        mRecipe = (Recipe) intent.getSerializableExtra("NAME_Recipe");

        mRecipeDetailsFragment = RecipeDetailsFragment.newInstance(mRecipe);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.details_recipe, mRecipeDetailsFragment)
                .commit();

    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mToolbar;
    }
}
