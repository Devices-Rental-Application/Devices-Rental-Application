package com.neonadeuri.devices_rental_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class application_page extends AppCompatActivity {

    TextView deviceName;
    EditText name;
    EditText phoneNumber;
    Button applicationBtn;
    Device d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_page);

        Intent intent=getIntent();
        d=(Device) intent.getSerializableExtra("device");
        User user=new User();

        deviceName=findViewById(R.id.deviceName);
        name=findViewById(R.id.name);
        phoneNumber=findViewById(R.id.phoneNumber);


        deviceName.setText(d.getName());
        name.setText(user.getName());
        phoneNumber.setText(user.getPhoneNumber());

        applicationBtn=(Button) findViewById(R.id.applicationBtn);

        applicationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseController dataBaseController=new DataBaseController();
                DatabaseReference device=dataBaseController.getDeviceDataBase(d.getId());
                d.setCurrentCnt(d.getCurrentCnt()-1);
                device.setValue(d);
                Intent intent =new Intent(getApplicationContext(),application_status.class);
                startActivity(intent);
                finish();
            }
        });
    }
}