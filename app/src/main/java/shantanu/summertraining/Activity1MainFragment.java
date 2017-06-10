package shantanu.summertraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import shantanu.summertraining.Fragments.MainFragment;

public class Activity1MainFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1_main_fragment);

        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, MainFragment
                .newInstance()).commit();


    }
}
