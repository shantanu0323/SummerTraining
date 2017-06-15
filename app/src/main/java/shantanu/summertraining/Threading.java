package shantanu.summertraining;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Threading extends AppCompatActivity {

    private static final String TAG = "Threading";

    private Button bStartThread;
    private TextView tvResult;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tvResult.setText(String.valueOf(msg.getData().getDouble("value")));
        }
    };

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
//                bStartThread.setEnabled(false);
                Thread.sleep(3000);
                double v = Math.random();
                Message message = handler.obtainMessage();
                message.getData().putDouble("value", v);
                handler.sendMessage(message);
                Log.i(TAG, "run: " + v);
//                tvResult.setText(String.valueOf(v));
//                bStartThread.setEnabled(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threading);

        tvResult = (TextView) findViewById(R.id.tvResult);
        bStartThread = (Button) findViewById(R.id.bStartThread);
        bStartThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Thread thread = new Thread(runnable);
                    bStartThread.setEnabled(false);
                    thread.start();
                    bStartThread.setEnabled(true);
                } catch (Exception e) {
                    Log.e(TAG, "onClick: ", e);
                }
                Toast.makeText(Threading.this, "New Thread Started", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
