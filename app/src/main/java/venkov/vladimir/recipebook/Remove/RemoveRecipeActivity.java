package venkov.vladimir.recipebook.Remove;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import venkov.vladimir.recipebook.R;
import venkov.vladimir.recipebook.views.BaseDrawerActivity;

public class RemoveRecipeActivity extends BaseDrawerActivity {

    public static final long IDENTIFIER = 3;
    private RemoveRecipeFragment mRemoveRecipeFragment;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_recipe);
        mToolbar = findViewById(R.id.drawer_toolbar);
        setSupportActionBar(mToolbar);

        mRemoveRecipeFragment = RemoveRecipeFragment.newInstance();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.removeActivity, mRemoveRecipeFragment)
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
