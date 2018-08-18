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

        mListOfRecipiesAdapter = new ArrayAdapter<>(
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
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        mRecipeListView = view.findViewById(R.id.lv_recipe_list);

        init();

        mRecipeListView.setAdapter(mListOfRecipiesAdapter);
        mRecipeListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        //position which was clicked in the adapter
        String keyName = mListOfRecipiesAdapter.getItem(position);
        Recipe recipe = mListOfRecipies.get(keyName);
        mOnRecipeItemClickListener.onClick(recipe);
    }

    public void setOnRecipeItemClickListener(OnRecipeItemClickListener listener) {
        mOnRecipeItemClickListener = listener;
    }

    public static RecipeListFragment newInstance() {
        return new RecipeListFragment();
    }

    public interface OnRecipeItemClickListener {
        void onClick(Recipe recipe);
    }
}
