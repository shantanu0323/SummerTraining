package shantanu.summertraining;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SquareApp extends AppCompatActivity {

    private EditText etValue;
    private Button bSquare;
    private TextView tvAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_app);

        init();


        bSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strValue = etValue.getText().toString().trim();
                if (!TextUtils.isEmpty(strValue)) {
                    int value = Integer.parseInt(strValue);
                    int answer = value * value;
                    tvAnswer.setTextColor(Color.rgb(0,170,0));
                    tvAnswer.setText("" + answer);
                } else {
                    tvAnswer.setTextColor(Color.RED);
                    tvAnswer.setText("Field Cannot be left blank");
                }
            }
        });

    }

    private void init() {
        etValue = (EditText) findViewById(R.id.etValue);
        bSquare = (Button) findViewById(R.id.bSquare);
        tvAnswer = (TextView) findViewById(R.id.tvAnswer);
    }

}
