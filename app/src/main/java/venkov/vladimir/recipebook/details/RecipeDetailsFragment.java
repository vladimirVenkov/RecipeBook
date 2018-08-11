package venkov.vladimir.recipebook.details;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import venkov.vladimir.recipebook.R;
import venkov.vladimir.recipebook.Recipe.Recipe;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeDetailsFragment extends Fragment {
    private Recipe mRecipe;
    private ArrayAdapter<String> mRecipeAdapter;
    private ListView mRecipeView;


    public RecipeDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe_details, container, false);

        mRecipeView = view.findViewById(R.id.lv_recipe_details);

        mRecipeAdapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1
        );
        mRecipeAdapter.add(mRecipe.getName());
        mRecipeAdapter.add("Ingredients:");
        mRecipeAdapter.add(mRecipe.getIngredients());
        mRecipeAdapter.add("Cooking:");
        mRecipeAdapter.add(mRecipe.getCookingOperations());

        mRecipeView.setAdapter(mRecipeAdapter);

        return view;
    }

    public static RecipeDetailsFragment newInstance(Recipe recipe) {
        RecipeDetailsFragment fragment = new RecipeDetailsFragment();
        fragment.mRecipe = recipe;
        return fragment;
    }
}
