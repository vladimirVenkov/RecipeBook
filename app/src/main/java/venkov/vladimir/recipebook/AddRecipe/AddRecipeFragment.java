package venkov.vladimir.recipebook.AddRecipe;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import venkov.vladimir.recipebook.R;
import venkov.vladimir.recipebook.Recipe.Recipe;
import venkov.vladimir.recipebook.repositories.Base.Repository;
import venkov.vladimir.recipebook.repositories.FirebaseRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddRecipeFragment extends Fragment {
    private Repository<Recipe> mFirebaseRepository;
    private TextView mTextView;
    private Button mButton;
    private Recipe mRecipe;
    private EditText mName;
    private EditText mIngredients;
    private EditText mCookingOperations;

    public AddRecipeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_recipe, container, false);
        mTextView = view.findViewById(R.id.title_add_text);
        mButton = view.findViewById(R.id.add_button_recipe);
        mFirebaseRepository = new FirebaseRepository<>(Recipe.class);

        mName = view.findViewById(R.id.enter_name_recipe);
        mIngredients = view.findViewById(R.id.enter_ingredients_recipe);
        mCookingOperations = view.findViewById(R.id.enter_cooking_operations_recipe);

        createRecipe(mName, mIngredients, mCookingOperations);

        mButton.setOnClickListener(view1 -> mFirebaseRepository.add(mRecipe, mRecipe -> {}));
        //mFirebaseRepository.add(mRecipe, mRecipe -> {});

        return view;
    }

    private void createRecipe(EditText name, EditText ingredients, EditText cookingOperations) {
        mRecipe = new Recipe(name.getText().toString(),
                ingredients.getText().toString(),
                cookingOperations.getText().toString());
    }

    private void createRecipe() {
        mRecipe = new Recipe("Mashed potatoes",
                "potatoes",
                "1.boiling;\n2.mashing" );
    }

    public static AddRecipeFragment newInstance() {
        return new AddRecipeFragment();
    }
}
