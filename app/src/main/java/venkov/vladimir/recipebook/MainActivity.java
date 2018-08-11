package venkov.vladimir.recipebook;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import venkov.vladimir.recipebook.ListAllRecipe.ListAllActivity;

public class MainActivity extends Activity {
    private RecipeListFragment mRecipeListFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.start_button)
                .setOnClickListener(view -> {
                    Intent intent = new Intent(
                            this,
                            ListAllActivity.class
                    );
                    startActivity(intent);
                });
        //        mRecipeListFragment = RecipeListFragment.newInstance();
//        getFragmentManager()
//                .beginTransaction()
//                .replace(R.id.content, mRecipeListFragment)
//                .commit();
    }
}
