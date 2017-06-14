package shantanu.summertraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> listItems;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView = (ListView) findViewById(R.id.listView);
        listItems = new ArrayList<String>();
        listItems.add("MainActivity");
        listItems.add("SquareApp");
        listItems.add("AdvanceCalc");
        listItems.add("SimpleInterest");
        listItems.add("ImplicitIntent");
        listItems.add("EmailSend");
        listItems.add("ActivityContainingFragment");
        listItems.add("DynamicActivity");
        listItems.add("Activity1MainFragment");
        listItems.add("ListViewImplementation");
        listItems.add("CustomListView");
        listItems.add("DatabaseActivity");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String className = listItems.get(position);
                Intent intent = new Intent();
                intent.setClassName("shantanu.summertraining", "shantanu.summertraining." +
                        className);
                startActivity(intent);
            }
        });
    }
}
