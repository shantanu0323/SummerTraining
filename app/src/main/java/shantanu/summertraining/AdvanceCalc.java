package shantanu.summertraining;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class AdvanceCalc extends AppCompatActivity {

    private EditText etFirst;
    private EditText etSecond;
    private RadioGroup radioGroup;
    private TextView tvResult;
    private CheckBox cbFloatingDiv;
    private boolean floatingIsChecked = false;
    private boolean divRBchecked = false;
    private Spinner spinner;
    private Button bCalculate;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_calc);

        etFirst = (EditText) findViewById(R.id.etFirst);
        etSecond = (EditText) findViewById(R.id.etSecond);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        tvResult = (TextView) findViewById(R.id.tvResult);
        cbFloatingDiv = (CheckBox) findViewById(R.id.cbFloatingDiv);
        spinner = (Spinner) findViewById(R.id.spinner);
        bCalculate = (Button) findViewById(R.id.bCalculate);
        intent = new Intent(getApplicationContext(), ResultActivity.class);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (!TextUtils.isEmpty(etFirst.getText().toString().trim()) &&
                        !TextUtils.isEmpty(etSecond.getText().toString().trim())) {
                    int first = Integer.parseInt(etFirst.getText().toString().trim());
                    int second = Integer.parseInt(etSecond.getText().toString().trim());
                    String action = "";
                    switch (checkedId) {
                        case R.id.rbAdd:
                            tvResult.setText("" + (first + second));
                            divRBchecked = false;
                            action = "Addition";
                            break;
                        case R.id.rbSubtract:
                            tvResult.setText("" + (first - second));
                            divRBchecked = false;
                            action = "Subtraction";
                            break;
                        case R.id.rbMultiply:
                            tvResult.setText("" + (first * second));
                            divRBchecked = false;
                            action = "Product";
                            break;
                        case R.id.rbDivide:
                            divRBchecked = true;
                            if (floatingIsChecked) {
                                double result = (double) first / second;
                                tvResult.setText("" + result);
                                action = "Division";
                            } else {
                                int result = first / second;
                                tvResult.setText("" + result);
                                action = "Floating Division";
                            }
                            break;

                    }
                    tvResult.setTextColor(Color.rgb(0, 170, 0));
//                    intent.putExtra("result", tvResult.getText().toString());
//                    intent.putExtra("first", String.valueOf(first));
//                    intent.putExtra("second", String.valueOf(second));
//                    intent.putExtra("action", action);
//                    startActivity(intent);
                } else {
                    tvResult.setText("Field cannot be left blank");
                    tvResult.setTextColor(Color.RED);
                }
                if (divRBchecked) {
                    cbFloatingDiv.setEnabled(true);
                } else {
                    cbFloatingDiv.setEnabled(false);
                }
            }
        });

        cbFloatingDiv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!TextUtils.isEmpty(etFirst.getText().toString().trim()) &&
                        !TextUtils.isEmpty(etSecond.getText().toString().trim())) {
                    int first = Integer.parseInt(etFirst.getText().toString().trim());
                    int second = Integer.parseInt(etSecond.getText().toString().trim());
                    floatingIsChecked = isChecked;
                    if (isChecked) {
                        double result = (double) first / second;
                        tvResult.setText("" + result);
                    } else {
                        int result = first / second;
                        tvResult.setText("" + result);
                    }
                    tvResult.setTextColor(Color.rgb(0, 170, 0));
//                    intent.putExtra("result", tvResult.getText().toString());
//                    intent.putExtra("first", String.valueOf(first));
//                    intent.putExtra("second", String.valueOf(second));
//                    intent.putExtra("action", "Floating Division");
//                    startActivity(intent);
                } else {
                    tvResult.setText("Field cannot be left blank");
                    tvResult.setTextColor(Color.RED);
                }
            }
        });

        bCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = spinner.getSelectedItemPosition();
                String[] actions = getResources().getStringArray(R.array.actions);
                String action = actions[position];
                if (!TextUtils.isEmpty(etFirst.getText().toString().trim()) &&
                        !TextUtils.isEmpty(etSecond.getText().toString().trim())) {
                    int first = Integer.parseInt(etFirst.getText().toString().trim());
                    int second = Integer.parseInt(etSecond.getText().toString().trim());
                    {
                        switch (action) {
                            case "Addition":
                                tvResult.setText("" + (first + second));
                                break;
                            case "Subtraction":
                                tvResult.setText("" + (first - second));
                                break;
                            case "Product":
                                tvResult.setText("" + (first * second));
                                break;
                            case "Division":
                                tvResult.setText("" + (first / second));
                                break;
                            case "Floating Division":
                                tvResult.setText("" + ((double) first / second));
                                break;
                        }
                    }
                    tvResult.setTextColor(Color.rgb(0, 170, 0));
                    intent.putExtra("result", tvResult.getText().toString());
                    intent.putExtra("first", String.valueOf(first));
                    intent.putExtra("second", String.valueOf(second));
                    intent.putExtra("action", action);
                    startActivity(intent);
                } else {
                    tvResult.setText("Field cannot be left blank");
                    tvResult.setTextColor(Color.RED);
                }
            }
        });
    }
}
