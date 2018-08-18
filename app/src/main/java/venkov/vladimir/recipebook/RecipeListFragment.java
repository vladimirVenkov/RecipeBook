package venkov.vladimir.recipebook;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;
import java.util.Map;

import venkov.vladimir.recipebook.Recipe.Recipe;
import venkov.vladimir.recipebook.repositories.Base.Repository;
import venkov.vladimir.recipebook.repositories.FirebaseRepository;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private Map<String, Recipe> mListOfRecipies;
    private ListView mRecipeListView;
    private ArrayAdapter<String> mListOfRecipiesAdapter;
    private OnRecipeItemClickListener mOnRecipeItemClickListener;
    private Repository<Recipe> mFirebaseRepository;

    public RecipeListFragment() {
        // Required empty public constructor
    }

    private void init() {

        mListOfRecipiesAdapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1
        );
        mListOfRecipies = new HashMap<>();
        mFirebaseRepository = new FirebaseRepository<>(Recipe.class);

        mFirebaseRepository.getAll(recipes -> {
            for (Recipe recipe : recipes) {
                mListOfRecipiesAdapter.add(recipe.name);
                mListOfRecipies.put(recipe.name, recipe);
            }
        });



//
//        addRecipe("Mashed potatoes",
//                "potatoes",
//                "1.boiling;\n2.mashing" );
//        addRecipe("Princess",
//                "1.bread;\n2. yellow cheese",
//                "1.put yellow cheese on the bread and\n2.bake");
//        addRecipe("Tarator",
//                "1. cucumbers;\n2. kiselo mlqko;\n3. garlic",
//                "1. cut the cucumbers to small cubes;\n2. Mash the garlic;\n3. Stir everything");

        //mListOfRecipies.forEach(x -> mListOfRecipiesAdapter.add(x.getName()));


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        mRecipeListView = view.findViewById(R.id.lv_recipe_list);

        init();


        mRecipeListView.setAdapter(mListOfRecipiesAdapter);
        mRecipeListView.setOnItemClickListener(this);

        return view;
    }

    private void addRecipe(String name, String ingredients, String cookingOperations) {
        mListOfRecipies.put(name, new Recipe(name, ingredients, cookingOperations));
        mListOfRecipiesAdapter.add(name);
    }

    private void deleteRecipe(Recipe thisRecipe) {
        mListOfRecipies.remove(thisRecipe);
        mListOfRecipiesAdapter.remove(thisRecipe.getName());
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        //position which was clicked in the adapter
        String keyName = mListOfRecipiesAdapter.getItem(position);
        Recipe recipe = mListOfRecipies.get(keyName);
//        view.findViewById()
        mOnRecipeItemClickListener.onClick(recipe);
    }

    public void setOnRecipeItemClickListener(OnRecipeItemClickListener listener) {

        // ListAll....
        //  mRecipeListFragment.setOnRecip.....Click(this);
        mOnRecipeItemClickListener = listener;
    }

    public static RecipeListFragment newInstance() {
        return new RecipeListFragment();
    }

    public interface OnRecipeItemClickListener {
        public void onClick(Recipe recipe);
    }
}
