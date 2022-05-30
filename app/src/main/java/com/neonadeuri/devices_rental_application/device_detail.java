package com.neonadeuri.devices_rental_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class device_detail extends AppCompatActivity {

    Button goToApplicationBtn;
    TextView name,nowCnt,description;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);

        Intent intent=getIntent();
        String id=intent.getStringExtra("id");

        DataBaseController dataBase=new DataBaseController();

        name=(TextView) findViewById(R.id.name);
        nowCnt=(TextView) findViewById(R.id.nowCount);
        description=(TextView) findViewById(R.id.description);
        image=(ImageView) findViewById(R.id.image) ;
        goToApplicationBtn=(Button) findViewById(R.id.goToApplicationBtn);

//        Device device = dataBase.getDevice(id);
//        name.setText(device.getName());
//        nowCnt.setText(""+device.getCurrentCnt());
//        description.setText(device.getDescription());

        goToApplicationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}