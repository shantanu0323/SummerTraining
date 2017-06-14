package shantanu.summertraining;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.TextView;

public class SMSReceive extends AppCompatActivity {

    private static final String TAG = "SMSReceive";

    private TextView tvMessage;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TAG, "onReceive: SMS RECEIVED");
            Bundle bundle = intent.getExtras();
            Object object = bundle.get("pdus");
            Object[] objects = (Object[]) object;

            SmsMessage[] smsMessages = new SmsMessage[objects.length];

            for (int i=0; i<smsMessages.length; i++) {
                Object x = objects[i];
                byte[] bytes = (byte[]) x;
                smsMessages[i] = SmsMessage.createFromPdu(bytes);
            }

            for (SmsMessage smsMessage:smsMessages) {
                String addr = smsMessage.getOriginatingAddress();
                String body = smsMessage.getMessageBody();
                tvMessage.setText(body);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsreceive);

        tvMessage = (TextView) findViewById(R.id.tvMessage);

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, new IntentFilter("android.provider.Telephony" +
                ".SMS_RECEIVED"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

}
