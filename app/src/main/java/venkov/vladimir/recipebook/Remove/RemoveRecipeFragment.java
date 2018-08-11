package venkov.vladimir.recipebook.Remove;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import venkov.vladimir.recipebook.R;
import venkov.vladimir.recipebook.RecipeListFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class RemoveRecipeFragment extends Fragment {


    private RecipeListFragment mRecipeListFragment;

    public RemoveRecipeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_remove_recipe, container, false);
        mRecipeListFragment = RecipeListFragment.newInstance();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.remove_Fragment, mRecipeListFragment)
                .commit();


        return view;
    }

    public static RemoveRecipeFragment newInstance() {
        return new RemoveRecipeFragment();
    }
}
