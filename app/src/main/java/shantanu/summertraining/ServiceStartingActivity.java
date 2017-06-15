package shantanu.summertraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ServiceStartingActivity extends AppCompatActivity {

    private static final String TAG = "ServiceStartingActivity";

    private Button bStartIntentService;
    private Button bStartStartedService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_starting);

        bStartIntentService = (Button) findViewById(R.id.bStartIntentService);
        bStartIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for starting an Intent Service
                startService(new Intent(getApplicationContext(), MyIntentService.class));
                Log.i(TAG, "onClick: INTENT SERVICE STARTED");
            }
        });

        bStartStartedService = (Button) findViewById(R.id.bStartStartedService);
        bStartStartedService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for starting an Intent Service
                startService(new Intent(getApplicationContext(), MyStartedService.class));
                Log.i(TAG, "onClick: STARTED SERVICE STARTED");
            }
        });
    }
}
