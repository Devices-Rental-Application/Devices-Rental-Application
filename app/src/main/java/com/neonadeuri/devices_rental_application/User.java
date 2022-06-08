package com.neonadeuri.devices_rental_application;

import java.util.ArrayList;

public class User {
    private static String name="홍길동";
    private static String phoneNumber="01012345678";
    private static ArrayList<DeviceHistory> histories=new ArrayList<DeviceHistory>();

    public static void setName(String name) {
        User.name = name;
    }

    public static void setPhoneNumber(String phoneNumber) {
        User.phoneNumber = phoneNumber;
    }

    public static String getName() {
        return name;
    }


    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static int addDeviceHistory(int resourceId, String state, String deviceName, String date, String receiver){
        histories.add(new DeviceHistory(resourceId,state,deviceName,date,receiver));
        return histories.size()-1;
    }

    public static DeviceHistory getHistoryByPos(int pos) {
        return histories.get(pos);
    }

    public static int historySize(){
        return histories.size();
    }
}
