package venkov.vladimir.recipebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import venkov.vladimir.recipebook.ListAllRecipe.ListAllActivity;
import venkov.vladimir.recipebook.views.customView.CustomBookView;

public class MainActivity extends Activity {
    private CustomBookView mCustomBookView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomBookView = findViewById(R.id.custom_view);
        mCustomBookView.setOnClickListener(view -> {
                    Intent intent = new Intent(
                            this,
                            ListAllActivity.class
                    );
                    startActivity(intent);
                });
    }
}
