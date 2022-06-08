package com.neonadeuri.devices_rental_application;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class searchPageActivity extends AppCompatActivity {

    static RecyclerView recyclerView2;
    static historyAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_serach_page);
        getSupportActionBar().hide();
        setTitle(" ");

        recyclerView2 = findViewById(R.id.historyRV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView2.setLayoutManager(linearLayoutManager);
        adapter2 = new historyAdapter();

        for(int i=1;i<=10;i++){
            if(i%2==0)
                adapter2.addItem(new DeviceHistory(R.drawable.orcam,i+"상태",i+"이름","날짜","받는사람"));
            else
                adapter2.addItem(new DeviceHistory(R.drawable.tackplus,i+"상태",i+"이름","날짜","받는사람"));

        }
        recyclerView2.setAdapter(adapter2);

    }

}
