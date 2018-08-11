package venkov.vladimir.recipebook.ListAllRecipe;

import android.app.Activity;
import android.os.Bundle;

import venkov.vladimir.recipebook.R;

public class ListAllActivity extends Activity {

    private ListAllFragment mListAllFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all);
        mListAllFragment = ListAllFragment.newInstance();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.listAll, mListAllFragment)
                .commit();
    }
}
