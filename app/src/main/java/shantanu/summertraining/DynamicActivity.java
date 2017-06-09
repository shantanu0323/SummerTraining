package shantanu.summertraining;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import shantanu.summertraining.Fragments.DynamicFragment;

public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        // Dynamically adds a fragment to the activity
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, DynamicFragment.newInstance())
                .commit();


    }
}
