package shantanu.summertraining;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomListView extends AppCompatActivity {

    private ListView lvCourses;
    private CourseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        lvCourses = (ListView) findViewById(R.id.lvCourses);
        lvCourses.setEmptyView(findViewById(R.id.tvEmptyState));

        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        try {
            databaseHelper.createNewDatabase(new Course(101, "Android", 7000, 63));
            databaseHelper.createNewDatabase(new Course(201, "Big Data", 10000, 75));
            databaseHelper.createNewDatabase(new Course(301, "Web Development", 6000, 56));
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Course> course = databaseHelper.getAllCourses();
        adapter = new CourseAdapter(this, 0, course);
        lvCourses.setAdapter(adapter);
    }
}
