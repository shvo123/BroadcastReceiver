package com.edu.ness.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ConnectionReceiver receiver;
    IntentFilter intentFilter;
    Button send_broadcast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send_broadcast = findViewById(R.id.send_broadcast);
        send_broadcast.setOnClickListener(this);

        receiver = new ConnectionReceiver();
        intentFilter = new IntentFilter("com.edu.ness.broadcastreceiver.SOME_ACTION");

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(receiver);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent("com.edu.ness.broadcastreceiver.SOME_ACTION");
        sendBroadcast(intent);

    }
}
