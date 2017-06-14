package shantanu.summertraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class BroadcastRecieve extends AppCompatActivity {

    private static final String TAG = "BroadcastRecieve";

    private Button bBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_recieve);

        bBroadcast = (Button) findViewById(R.id.bBroadcast);
        bBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: Brocasting....");
                Intent intent = new Intent("com.vit.shantanu");
                getApplicationContext().sendBroadcast(intent);
            }
        });
    }
}
