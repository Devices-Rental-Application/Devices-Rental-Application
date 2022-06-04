package com.neonadeuri.devices_rental_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class application_status extends AppCompatActivity {

    TextView status,deviceName,date,recipient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_status);
        getSupportActionBar().hide();

        Intent intent=getIntent();
        int pos=intent.getIntExtra("pos",0);
        DeviceHistory history=User.getHistoryByPos(pos);

        status=findViewById(R.id.status);
        deviceName=findViewById(R.id.deviceName);
        date=findViewById(R.id.date);
        recipient=findViewById(R.id.recipient);

        status.setText(history.getState());
        deviceName.setText(history.getDeviceName());
        date.setText(history.getDate());
        recipient.setText(history.getReceiver());
    }
}