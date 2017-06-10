package shantanu.summertraining;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListViewImplementationFragment extends Fragment {

    private ListView lvCourses;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    public ListViewImplementationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_view_implementation, container, false);
        items = new ArrayList<>();
        items.add("Android");
        items.add("PHP");
        items.add("WebDevelopment");
        items.add("Python");
        items.add("Big Data");

        lvCourses = (ListView) root.findViewById(R.id.lvCourses);
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,
                items);
        lvCourses.setAdapter(adapter);

        return root;
    }
}
