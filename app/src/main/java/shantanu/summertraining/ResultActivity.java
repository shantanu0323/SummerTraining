package shantanu.summertraining;

import android.animation.TimeInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private String result;
    private String first;
    private String second;
    private String action;
    private TextView tvResult;
    private String output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Explode explode = new Explode();
        explode.setDuration(1500);
        
        setContentView(R.layout.activity_result);

        tvResult = (TextView) findViewById(R.id.tvResult);

        result = getIntent().getStringExtra("result");
        first = getIntent().getStringExtra("first");
        second = getIntent().getStringExtra("second");
        action = getIntent().getStringExtra("action");

        output = getIntent().getStringExtra("output");
        if (output != null) {
            tvResult.setText(output);
        } else {
            tvResult.setText("The Result of\n" + action + "\nof\n" + first + " and " + second +
                    "\nis\n" + result);
        }
    }
}
