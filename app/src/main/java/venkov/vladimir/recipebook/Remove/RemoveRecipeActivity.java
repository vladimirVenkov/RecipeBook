package venkov.vladimir.recipebook.Remove;

import android.app.Activity;
import android.os.Bundle;

import venkov.vladimir.recipebook.R;

public class RemoveRecipeActivity extends Activity {

    private RemoveRecipeFragment mRemoveRecipeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_recipe);
        mRemoveRecipeFragment = RemoveRecipeFragment.newInstance();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.removeActivity, mRemoveRecipeFragment)
                .commit();
    }
}
