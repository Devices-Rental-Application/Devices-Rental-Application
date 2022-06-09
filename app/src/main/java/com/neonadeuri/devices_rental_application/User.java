/*
 * 작성자:이혁수
 * */
package com.neonadeuri.devices_rental_application;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private static String name="홍길동";
    private static String phoneNumber="01012345678";
    private static ArrayList<DeviceHistory> histories=new ArrayList<DeviceHistory>();
    private static HashMap<String, Device> dibs = new HashMap<String, Device>();

    public static void addDib(Device device){
        dibs.put(device.getId(),device);
    }

    public static void removeDib(Device device){
        dibs.remove(device.getId());
    }

    public static boolean isContain(String id) {
        return dibs.containsKey(id);
    }

    public static HashMap<String, Device> getDibs() {
        return dibs;
    }

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
