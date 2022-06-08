package com.neonadeuri.devices_rental_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class application_page extends AppCompatActivity {

    TextView deviceName;
    EditText name;
    EditText phoneNumber;
    Button applicationBtn;
    Device d;
    User user;
    EditText year,month,day,hour,minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_page);
        setTitle("신청페이지");
        getSupportActionBar().hide();

        Intent intent=getIntent();
        d=(Device) intent.getSerializableExtra("device");
        user=new User();

        deviceName=findViewById(R.id.deviceName);
        name=findViewById(R.id.name);
        phoneNumber=findViewById(R.id.phoneNumber);
        year=findViewById(R.id.year);
        month=findViewById(R.id.month);
        day=findViewById(R.id.day);
        hour=findViewById(R.id.hour);
        minute=findViewById(R.id.minute);



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

                int pos;
                String date=year.getText().toString()+"년"+
                        month.getText().toString()+"월"+
                        day.getText().toString()+"일 "+
                        hour.getText().toString()+"시"+
                        minute.getText().toString()+"분";
                pos=user.addDeviceHistory(d.getResourceId(),"대기중",d.getName(),date,name.getText().toString());
                Intent intent =new Intent(getApplicationContext(),application_status.class);
                intent.putExtra("pos",pos);
                startActivity(intent);
                finish();
            }
        });
    }
}