package shantanu.summertraining;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SHAAN on 13-06-17.
 */

public class CourseAdapter extends ArrayAdapter<Course> {
    private static final String TAG = "CourseAdapter";

    public CourseAdapter(Context context, int resource, ArrayList<Course> courses) {
        super(context, resource, courses);
        Log.e(TAG, "CourseAdapter: " + courses.size());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.e(TAG, "getView: CALLED");
        View rowView = convertView;
        if (rowView == null) {
            Log.e(TAG, "getView: rowView = null");
            rowView = LayoutInflater.from(getContext()).inflate(R.layout.courses_row, parent,
                    false);
        }

        Course course = getItem(position);
        TextView tvTitle = ((TextView) rowView.findViewById(R.id.tvTitle));
        TextView tvCid = (TextView) rowView.findViewById(R.id.tvCid);
        TextView tvPrice = (TextView) rowView.findViewById(R.id.tvPrice);
        TextView tvHours = (TextView) rowView.findViewById(R.id.tvHours);
        tvTitle.setText(course.getTitle());
        tvCid.setText(String.valueOf(course.getCid()));
        tvPrice.setText("Rs. " + String.valueOf(course.getPrice()));
        tvHours.setText(String.valueOf(course.getHours()) + " hours");

        return rowView;
    }
}
