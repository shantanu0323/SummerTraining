package shantanu.summertraining;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AdvanceCalc extends AppCompatActivity {

    private EditText etFirst;
    private EditText etSecond;
    private RadioGroup radioGroup;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_calc);

        etFirst = (EditText) findViewById(R.id.etFirst);
        etSecond = (EditText) findViewById(R.id.etSecond);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        tvResult = (TextView) findViewById(R.id.tvResult);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int first = Integer.parseInt(etFirst.getText().toString().trim());
                int second = Integer.parseInt(etSecond.getText().toString().trim());
                switch (checkedId) {
                    case R.id.rbAdd:
                        tvResult.setText("" + (first + second));
                        break;
                    case R.id.rbSubtract:
                        tvResult.setText("" + (first - second));
                        break;
                    case R.id.rbMultiply:
                        tvResult.setText("" + (first * second));
                        break;
                    case R.id.rbDivide:
                        tvResult.setText("" + (float)(first / second));
                        break;

                }
            }
        });

    }
}
