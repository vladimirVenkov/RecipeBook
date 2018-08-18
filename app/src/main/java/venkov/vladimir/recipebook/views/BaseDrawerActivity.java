package venkov.vladimir.recipebook.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import venkov.vladimir.recipebook.AddRecipe.AddRecipeActivity;
import venkov.vladimir.recipebook.ListAllRecipe.ListAllActivity;
import venkov.vladimir.recipebook.Remove.RemoveRecipeActivity;

public abstract class BaseDrawerActivity extends AppCompatActivity {

    public void setupDrawer() {
        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem listAllRecipeItem = new PrimaryDrawerItem()
                .withIdentifier(ListAllActivity.IDENTIFIER)
                .withName("List All Recipe");
        PrimaryDrawerItem removeRecipeItem = new PrimaryDrawerItem()
                .withIdentifier(RemoveRecipeActivity.IDENTIFIER)
                //.withIcon(R.drawable.material_drawer_circle_mask)
                .withName("Remove Recipe");
        PrimaryDrawerItem addRecipeItem = new PrimaryDrawerItem()
                .withIdentifier(AddRecipeActivity.IDENTIFIER)
                .withName("Add Recipe");

//create the drawer and remember the `Drawer` result object
        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(getDrawerToolbar())
                .addDrawerItems(
                        listAllRecipeItem,
                        new DividerDrawerItem(),
                        removeRecipeItem,
                        new DividerDrawerItem(),
                        addRecipeItem
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        long identifier = drawerItem.getIdentifier();
                        if (getIdentifier() == identifier) {
                            return false;
                        }
                        Intent intent = getNextIntent(identifier);
                        if (intent == null) {
                            return false;
                        }

                        startActivity(intent);
                        return true;
                    }
                })
                .build();
    }
    //TODO 1:22:01
    private Intent getNextIntent(long identifier) {
        if (identifier == ListAllActivity.IDENTIFIER){
            return new Intent(BaseDrawerActivity.this,
                    ListAllActivity.class);

        }else if(identifier == RemoveRecipeActivity.IDENTIFIER) {
            return new Intent(BaseDrawerActivity.this,
                    RemoveRecipeActivity.class);
        } else if (identifier == AddRecipeActivity.IDENTIFIER) {
            return new Intent(BaseDrawerActivity.this,
                    AddRecipeActivity.class);
        }

        return null;
    }

    protected abstract long getIdentifier();

    protected abstract Toolbar getDrawerToolbar();

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }
}
