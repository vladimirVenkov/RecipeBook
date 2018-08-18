package venkov.vladimir.recipebook.AddRecipe;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import venkov.vladimir.recipebook.R;
import venkov.vladimir.recipebook.views.BaseDrawerActivity;

public class AddRecipeActivity extends BaseDrawerActivity {

    public static final long IDENTIFIER = 5;
    private Toolbar mToolbar;
    private AddRecipeFragment mAddRecipeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        mToolbar = findViewById(R.id.drawer_toolbar);
        setSupportActionBar(mToolbar);

        mAddRecipeFragment = AddRecipeFragment.newInstance();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.addRecipe, mAddRecipeFragment)
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
