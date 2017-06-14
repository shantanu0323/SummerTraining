package shantanu.summertraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    private EditText etTitle;
    private Button bSearch;
    private LinearLayout searchResults;

    private static final String TAG = "SearchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etTitle = (EditText) findViewById(R.id.etTitle);
        bSearch = (Button) findViewById(R.id.bSearch);
        searchResults = (LinearLayout) findViewById(R.id.searchResult);

        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
                Course course = databaseHelper.getCourse(etTitle.getText().toString().trim());
                if (course != null) {
                    searchResults.setVisibility(View.VISIBLE);
                    try {
                        Log.i(TAG, "title: " + (((TextView) findViewById(R.id.tvTitle)) == null));
                        Log.i(TAG, "cid  : " + (((TextView) findViewById(R.id.tvCid)) == null));
                        Log.i(TAG, "price: " + (((TextView) findViewById(R.id.tvPrice)) == null));
                        Log.i(TAG, "hours: " + (((TextView) findViewById(R.id.tvHours)) == null));
                        ((TextView) findViewById(R.id.tvTitle)).setText(course.getTitle());
                        ((TextView) findViewById(R.id.tvCid)).setText(course.getCid());
                        ((TextView) findViewById(R.id.tvPrice)).setText(course.getPrice());
                        ((TextView) findViewById(R.id.tvHours)).setText(course.getHours());
                    } catch (Exception e) {
                        Log.e(TAG, "onClick: ERROR", e);
                    }
                } else {
                    Log.e(TAG, "onClick: NOT FOUND");
                    Toast.makeText(SearchActivity.this, "Sorry!!! No such Course found...", Toast
                            .LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
                break;
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        return true;
    }
}




