package shantanu.summertraining.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import shantanu.summertraining.R;
import shantanu.summertraining.ResultActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final EditText etName = (EditText) root.findViewById(R.id.etName);
        Button bOK = (Button) root.findViewById(R.id.bOK);
        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Name is : " + etName.getText().toString().trim(),
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), ResultActivity.class);
                intent.putExtra("output", "Hello " + etName.getText().toString());
                startActivity(intent);
            }
        });

        return root;
    }

}
