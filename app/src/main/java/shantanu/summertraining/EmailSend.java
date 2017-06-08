package shantanu.summertraining;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EmailSend extends AppCompatActivity {

    private Button bEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_send);

        bEmail = (Button) findViewById(R.id.bEmail);
        bEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

    }

    private void sendEmail() {
        String[] sendTo = {"aman.singh1495@gmail.com", "shantanu.pramanik2015@vit.ac.in"};
        String[] sendCc = {"srs.shaan@gmail.com"};


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, sendTo);
        intent.putExtra(Intent.EXTRA_CC, sendCc);
        intent.putExtra(Intent.EXTRA_SUBJECT, "This is an auto-generated email");
        intent.putExtra(Intent.EXTRA_TEXT, "Hello guyz this is the body of the email");
        startActivity(intent);
    }
}
