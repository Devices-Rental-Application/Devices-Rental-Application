package com.neonadeuri.devices_rental_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class device_detail extends AppCompatActivity {

    Button goToApplicationBtn;
    TextView name,nowCnt,description;
    ImageView img;
    Device d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);

        Intent intent=getIntent();
        String id=intent.getStringExtra("id");

        name=(TextView) findViewById(R.id.name);
        nowCnt=(TextView) findViewById(R.id.nowCount);
        description=(TextView) findViewById(R.id.description);
        img=(ImageView) findViewById(R.id.image) ;
        goToApplicationBtn=(Button) findViewById(R.id.goToApplicationBtn);

        DataBaseController dataBaseController=new DataBaseController();

        DatabaseReference device = dataBaseController.getDeviceDataBase(id);
        //TODO:리스너 새로 등록하면 이전 리스너 사라지기에 이페이지에서 나갈때 리사이클러뷰쪽 리스너 새로 등록
        device.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                d = snapshot.getValue(Device.class);
                if (d == null) return;
                name.setText(d.getName());
                nowCnt.setText("남은수량: "+d.getCurrentCnt());
                description.setText(d.getDescription());
                img.setImageResource(d.getResourceId());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        goToApplicationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),application_page.class);
                intent.putExtra("name",d.getName());
                startActivity(intent);
                finish();
            }
        });
    }
}