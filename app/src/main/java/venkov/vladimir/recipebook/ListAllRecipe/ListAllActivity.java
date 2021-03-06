package venkov.vladimir.recipebook.ListAllRecipe;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import venkov.vladimir.recipebook.R;
import venkov.vladimir.recipebook.views.BaseDrawerActivity;

public class ListAllActivity extends BaseDrawerActivity{

    public static final long IDENTIFIER = 1;
    private ListAllFragment mListAllFragment;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all);

        mToolbar = findViewById(R.id.drawer_toolbar);
        setSupportActionBar(mToolbar);
        mListAllFragment = ListAllFragment.newInstance();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.listAll, mListAllFragment)
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
