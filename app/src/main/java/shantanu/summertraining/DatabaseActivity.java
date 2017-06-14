package shantanu.summertraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DatabaseActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    private EditText etTitle;
    private EditText etPrice;
    private EditText etHours;
    private Button bAdd;

    private static final String TAG = "DatabaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        databaseHelper = new DatabaseHelper(getApplicationContext());

        etTitle = (EditText) findViewById(R.id.etTitle);
        etPrice = (EditText) findViewById(R.id.etPrice);
        etHours = (EditText) findViewById(R.id.etHours);
        bAdd = (Button) findViewById(R.id.bAdd);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Course course = new Course(100,
                        etTitle.getText().toString(),
                        Integer.parseInt(etPrice.getText().toString()),
                        Integer.parseInt(etHours.getText().toString()));
                try {
                    databaseHelper.createNewDatabase(course);
                } catch (Exception e) {
                    Log.e(TAG, "onClick: CREATING COURSE ERROR : ", e);
                }
                Log.i(TAG, "onClick: Course Added");
            }
        });
    }
}
