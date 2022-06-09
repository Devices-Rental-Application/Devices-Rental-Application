/*
 * 작성자:이혁수
 */
package com.neonadeuri.devices_rental_application;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class DataBaseController {
    static FirebaseDatabase database;
    static DatabaseReference idListDataBase;
    static DatabaseReference deviceDataBase;
    DataBaseController(){
        if(database!=null) return;
        database=FirebaseDatabase.getInstance();
        idListDataBase= database.getReference().child("idList");
        deviceDataBase= database.getReference().child("deviceList");
    }


    public static DatabaseReference getIdListDataBase() {
        return idListDataBase;
    }

    public static DatabaseReference getDeviceDataBase(String id) {
        return deviceDataBase.child(id);
    }
}
