package com.example.main_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ArrayList<AssistiveDevice> assistiveDivices = new ArrayList<AssistiveDevice>();

    private String selectedFilter = "all";
    private RecyclerView recyclerview;

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentSearch fragmentSearch = new FragmentSearch();
    private FragmentCamera fragmentCamera = new FragmentCamera();
    private FragmentCall fragmentCall = new FragmentCall();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadData();
//        recyclerview = findViewById(R.id.);

//        DeviceAdapter adapter = new DeviceAdapter(assistiveDivices);
//        recyclerview.setAdapter(adapter);
//        recyclerview.setLayoutManager(new LinearLayoutManager(this));


        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentSearch).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    private void filterList(String status) {
        selectedFilter = status;

        ArrayList<AssistiveDevice> filteredDivices = new ArrayList<AssistiveDevice>();

        for (AssistiveDevice assistiveDivice : assistiveDivices) {
            if (assistiveDivice.getName().toLowerCase().contains(status)) {
                filteredDivices.add(assistiveDivice);
            }
        }

        DeviceAdapter adapter = new DeviceAdapter(assistiveDivices);
        recyclerview.setAdapter(adapter);
    }

//    public void etcFilterTapped(View view) {
//    }

    // 장애 보조기구 목록 arraylist에 등록
    public void uploadData() {
        AssistiveDevice tackplus = new AssistiveDevice("tackplus", "택플러스 프린터", 4, 4);
        assistiveDivices.add(tackplus);

        AssistiveDevice orcam = new AssistiveDevice("orcam", "오르캠", 2, 7);
        assistiveDivices.add(orcam);
    }


    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(menuItem.getItemId())
            {
                case R.id.searchItem:
                    transaction.replace(R.id.frameLayout, fragmentSearch).commitAllowingStateLoss();

                    break;
                case R.id.cameraItem:
                    transaction.replace(R.id.frameLayout, fragmentCamera).commitAllowingStateLoss();
                    break;
                case R.id.callItem:
                    transaction.replace(R.id.frameLayout, fragmentCall).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }
}