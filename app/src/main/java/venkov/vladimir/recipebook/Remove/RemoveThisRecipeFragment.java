package venkov.vladimir.recipebook.Remove;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import venkov.vladimir.recipebook.ListAllRecipe.ListAllActivity;
import venkov.vladimir.recipebook.R;
import venkov.vladimir.recipebook.Recipe.Recipe;
import venkov.vladimir.recipebook.details.RecipeDetailsFragment;


public class RemoveThisRecipeFragment extends Fragment {
    private Recipe mRecipe;
    private RecipeDetailsFragment mRecipeDetailsFragment;
    private Button mYesIAmSure;
    private Button mNoDontDelete;
    private TextView mMessage;

    public RemoveThisRecipeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remove_this_recipe, container, false);
        mRecipeDetailsFragment = RecipeDetailsFragment.newInstance(mRecipe);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.recipe_details_fragment, mRecipeDetailsFragment)
                .commit();
        mMessage = view.findViewById(R.id.remove_message);
        mYesIAmSure = view.findViewById(R.id.YES_button);
        mNoDontDelete = view.findViewById(R.id.NO_button);

        mYesIAmSure.setOnClickListener(view1 ->{
            mRecipe.setDeleted(true);
            //TODO need to update firebase database - > probably need reworking of firebase implementation?
            Intent intent = new Intent(
                    getContext(),
                    ListAllActivity.class
            );
            startActivity(intent);
        } );

        mNoDontDelete.setOnClickListener(view1 -> {
            Intent intent = new Intent(
                    getContext(),
                    ListAllActivity.class
            );
            startActivity(intent);
        } );

        return view;
    }

    public static RemoveThisRecipeFragment newInstance(Recipe recipe) {
        RemoveThisRecipeFragment fragment = new RemoveThisRecipeFragment();
        fragment.mRecipe = recipe;
        return fragment;
    }
}
