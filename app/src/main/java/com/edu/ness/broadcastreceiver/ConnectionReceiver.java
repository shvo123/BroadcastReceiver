package com.edu.ness.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by anupamchugh on 11/04/16.
 */

public class ConnectionReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        Log.d("API123", "" + intent.getAction());

        if (intent.getAction().equals("com.edu.ness.broadcastreceiver.SOME_ACTION")) {
            Toast.makeText(context, "SOME_ACTION is received", Toast.LENGTH_LONG).show();
            return;
        }
        if (intent.getAction().equals("android.intent.action.AirplaneMode")) {
            Log.d("onReceive","android.intent.action.AirplaneMode");
            Toast.makeText(context, "android.intent.action.AirplaneMode received", Toast.LENGTH_LONG).show();
            return;
        }

        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (isConnected) {
            try {
                Toast.makeText(context, "Network is connected", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(context, "Network is changed or reconnected", Toast.LENGTH_LONG).show();
        }
    }
}
