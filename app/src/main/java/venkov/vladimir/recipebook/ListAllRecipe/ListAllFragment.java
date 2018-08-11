package venkov.vladimir.recipebook.ListAllRecipe;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import venkov.vladimir.recipebook.R;
import venkov.vladimir.recipebook.Recipe.Recipe;
import venkov.vladimir.recipebook.RecipeListFragment;
import venkov.vladimir.recipebook.details.RecipeDetailsActivity;
import venkov.vladimir.recipebook.details.RecipeDetailsFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListAllFragment extends Fragment implements RecipeListFragment.OnRecipeItemClickListener {


    private RecipeListFragment mRecipeListFragment;

    public ListAllFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_all, container, false);
        mRecipeListFragment = RecipeListFragment.newInstance();

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.listAll_Fragment, mRecipeListFragment)
                .commit();

        mRecipeListFragment.setOnRecipeItemClickListener(this);
        return view;
    }

    public static ListAllFragment newInstance() {
        return new ListAllFragment();
    }

    @Override
    public void onClick(Recipe recipe) {
        Intent intent = new Intent(
                getContext(),
                RecipeDetailsActivity.class
                );
        intent.putExtra("NAME_Recipe", recipe);
        startActivity(intent);
    }
}
