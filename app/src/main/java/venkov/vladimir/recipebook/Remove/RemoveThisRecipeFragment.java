package venkov.vladimir.recipebook.Remove;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import venkov.vladimir.recipebook.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RemoveThisRecipeFragment extends Fragment {


    public RemoveThisRecipeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_remove_this_recipe, container, false);


        return view;
    }

}
