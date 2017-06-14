package shantanu.summertraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    private EditText etTitle;
    private Button bSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etTitle = (EditText) findViewById(R.id.etTitle);
        bSearch = (Button) findViewById(R.id.bSearch);

        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
                Course course = databaseHelper.getCourse(etTitle.getText().toString().trim());
                if (course != null) {

                } else {
                    Toast.makeText(SearchActivity.this, "Sorry!!! No such Course found...", Toast
                            .LENGTH_SHORT).show();
                }
            }
        });
    }
}




