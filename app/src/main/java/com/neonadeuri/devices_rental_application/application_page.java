package com.neonadeuri.devices_rental_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class application_page extends AppCompatActivity {

    TextView deviceName;
    EditText name;
    EditText phoneNumber;
    Button applicationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_page);

        Intent intent=getIntent();
        String dName=intent.getStringExtra("deviceName");
        User user=new User();

        deviceName=findViewById(R.id.deviceName);
        name=findViewById(R.id.name);
        phoneNumber=findViewById(R.id.phoneNumber);


        deviceName.setText(dName);
        name.setText(user.getName());
        phoneNumber.setText(user.getPhoneNumber());

        applicationBtn=(Button) findViewById(R.id.applicationBtn);

        applicationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),application_status.class);
                startActivity(intent);
                finish();
            }
        });
    }
}