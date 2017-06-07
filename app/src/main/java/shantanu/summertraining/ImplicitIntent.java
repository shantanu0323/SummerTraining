package shantanu.summertraining;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class ImplicitIntent extends AppCompatActivity {

    private EditText etPhone;
    private ImageButton bDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        etPhone = (EditText) findViewById(R.id.etPhone);
        bDial = (ImageButton) findViewById(R.id.bDial);

        bDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "tel://" + etPhone.getText().toString().trim();
                Uri phoneUri = Uri.parse(phone);
                Intent intent = new Intent(Intent.ACTION_CALL, phoneUri);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
