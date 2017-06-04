package shantanu.summertraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Layout Params
    private TextView tvName;
    private EditText etName;
    private Button bOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(etName.getText().toString().trim())) {
                    tvName.setText(etName.getText().toString());
                    etName.setText("");
                } else {
                    tvName.setText("Please fill in the field...");
                }
            }
        });
    }

    private void init() {
        tvName = (TextView) findViewById(R.id.tvName);
        etName = (EditText) findViewById(R.id.etName);
        bOk = (Button) findViewById(R.id.bOk);
    }
}
