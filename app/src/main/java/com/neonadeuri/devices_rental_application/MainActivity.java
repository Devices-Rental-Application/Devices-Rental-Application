package com.neonadeuri.devices_rental_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnMyPage;

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentMyInfo fragmentMyInfo = new FragmentMyInfo();
    private FragmentMainPage fragmentMainPage = new FragmentMainPage();
    private FragmentDibs fragmentDibs = new FragmentDibs();
    private FragmentSearch fragmentSearch = new FragmentSearch();

    RecyclerView recyclerView;
    mainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.mainRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new mainAdapter();

        DataBaseController dataBaseController=new DataBaseController();
        dataBaseController.getIdListDataBase().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String temp = snapshot.getValue(String.class);
                if(temp==null) return;
                String[] idList=temp.split(",");

                for(String id:idList) {
                    DatabaseReference device = dataBaseController.getDeviceDataBase(id);
                    device.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Device d = snapshot.getValue(Device.class);
                            if (d == null) return;
                            int idx=adapter.getItemPosById(id);
                            if(idx==-1) {
                                adapter.addItem(d);
                            }
                            else {
                                adapter.setItem(idx,d);
                            }
                            recyclerView.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /****************************************************************************/
//        //recyclerView
//        recyclerView = findViewById(R.id.mainRecycler);
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        adapter = new mainAdapter();
//
//        for(int i=1;i<=10;i++){
//            if(i%2==0)
//                adapter.addItem(new Device(R.drawable.orcam,i+"번째 사람",i));
//            else
//                adapter.addItem(new Device(R.drawable.tackplus,i+"번째 사람",i));
//
//        }
//        recyclerView.setAdapter(adapter);
        /*******************************************************************************/


//        Intent intent = new Intent(this, myPageActivity.class);
//        startActivity(intent);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());






    }


    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(menuItem.getItemId())
            {
                case R.id.main:
                    transaction.replace(R.id.frameLayout, fragmentMainPage).commitAllowingStateLoss();
                    break;
                case R.id.myInfo:
                    transaction.replace(R.id.frameLayout, fragmentMyInfo).commitAllowingStateLoss();
                    break;
                case R.id.search:
                    transaction.replace(R.id.frameLayout, fragmentSearch).commitAllowingStateLoss();
                    break;
                case R.id.Dibs:
                    transaction.replace(R.id.frameLayout, fragmentDibs).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }

    public void openMyPage() {
        Intent intent = new Intent(this, myPageActivity.class);
        startActivity(intent);
    }
}