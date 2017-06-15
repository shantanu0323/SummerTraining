package shantanu.summertraining;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyStartedService extends Service {

    private static final String TAG = "MyStartedService";

    public MyStartedService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: CALLED");
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // runs on the UI Thread
    @Override
    public int onStartCommand(Intent intent,
                              int flags,
                              int startId) {
        Log.i(TAG, "onStartCommand: CALLED");
        return Service.START_STICKY; // Even if service is destroyed ... it restarts the  service
        // as soon as memory is available

        // OR return Service.START_NOT_STICKY; // If service is destroyed the the service is not
        // restarted

        // OR return Service.START_REDELIVER_INTENT;
    }
}
