package shantanu.summertraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SimpleInterest extends AppCompatActivity {


























    private EditText etPrinciple;
    private EditText etRate;
    private EditText etTime;
    private Button bCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_interest);

        etPrinciple = (EditText) findViewById(R.id.etPrinciple);
        etRate = (EditText) findViewById(R.id.etRate);
        etTime = (EditText) findViewById(R.id.etTime);
        bCalc = (Button) findViewById(R.id.bOK);

        bCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(etPrinciple.getText().toString()) &&
                        !TextUtils.isEmpty(etRate.getText().toString()) &&
                        !TextUtils.isEmpty(etTime.getText().toString())) {
                    double principle = Double.parseDouble(etPrinciple.getText().toString());
                    double rate = Double.parseDouble(etRate.getText().toString());
                    double time = Double.parseDouble(etTime.getText().toString());

                    double interest = (principle * rate * time) / 100;

                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("output", "The Simple Interest of\n" +
                            "Principle = Rs. " + principle + "\n" +
                            "with Rate = " + rate + " %\n" +
                            "for Time = " + time + " years is :\n" +
                            "Rs. " + interest);
                    startActivity(intent);
                } else {
                    Toast.makeText(SimpleInterest.this, "Fields cannot be left empty", Toast
                            .LENGTH_LONG).show();
                }
            }
        });
    }
}
